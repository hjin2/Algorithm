import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long[][] range;
    public static long result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        range = new long[n][3];

        StringTokenizer st = null;
        for(int tc = 0 ; tc < n ; tc++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken()); // 시작
            long b = Integer.parseInt(st.nextToken()); // 끝
            long c = Integer.parseInt(st.nextToken()); // 증가값

            range[tc][0] = a;
            range[tc][1] = b;
            range[tc][2] = c;

        }

        //이분탐색을 통해서 특정 값을 정하고, 그 특정 값 이하일때 정수의 개수가 몇개인지 확인한다.
        //                               전체 개수가 짝수개이면 -> 특정값 이하에는 짝수개인 수들밖에 없다
        //                                          홀수개이면 -> 특정값 이하에는 홀수개인 수가 존재한다.
        // 이분탐색
        long s = 1;
        long e = 2147483647;
        long mid;

        while(s <= e){
            mid = (s + e) / 2;

            // mid이하에 존재하는 숫자들의 개수 구하기
            // 존재하는 숫자가 짝수개 = (홀수개인 숫자)가 포함되어있지 않다
            if(find_under(mid) % 2 == 0){
                s = mid + 1;
            }else{  // 존재하는 숫자가 홀수개 = (홀수개인 숫자) 포함되어 있음
                e = mid - 1;
                result = mid;
            }
        }

        if(result != -1) {
            System.out.print(result + " "); // result에 든 값은 홀수개인 숫자
            System.out.println(find_under(result) - find_under(result - 1));
        }else{
            System.out.println("NOTHING");
        }
    }

    // num 이하에 존재하는 숫자들의 개수 구하기
    public static int find_under(long num){
        int total = 0;
        for(int i = 0 ; i < range.length ; i++){
            long a = range[i][0];
            long b = range[i][1];
            long c = range[i][2];

            if(a > num){
                continue;
            }

            if(b <= num) { // 마지막 값 <= 특정 수
                long tmp = (b - a) / c + 1;
                total += tmp;
            }else{         // 마지막 값 > 특정 수
                long tmp = (num - a) / c + 1;
                total += tmp;
            }


        }
        return total;
    }
}