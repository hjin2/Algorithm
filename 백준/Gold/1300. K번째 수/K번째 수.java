import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n,m;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 1. n*n했을 때 나올 수 있는 전체 숫자를 이분탐색으로 구한다.
        int s = 1;
        int e = m;
        int mid;

        while(s <= e){
            mid = (s + e) / 2;

            // 중간에 있는 값(t) t이하 숫자의 개수가 몇 개인지 구하기
            int count = find_under(mid);

            if(count >= m){
                e = mid - 1;
                result = mid;
            }else{
                s = mid + 1;
            }
        }


        System.out.println(result);
    }
    public static int find_under(int num){
        int total = 0;
        for(int i = 1 ; i <= n ; i++){
            total += Math.min(n, num / i);
        }

        return total;
    }
}