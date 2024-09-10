import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] nums;
    public static int result = 0;
    public static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];
        // 질투심 : 보석 개수가 가장 많은거 만큼만 가능, 한 사람이 한 종류의 색깔만 가져야하니까

        for(int i = 0 ; i < m ; i++){
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nums[i]);
        }

        int s = 1;
        int e = max;
        int mid;

        int person = n;

        if(n == m){
            System.out.println(max);
            System.exit(0);
        }
        while(s <= e){
            mid = (s + e) / 2;

            // 최대 mid개만큼 나누어줄 것이다.
            for(int i = 0 ; i < m ; i++){
                if(nums[i] <= mid){
                    person -= 1;
                }else{ // nums[i] > mid
                    int tmp = nums[i] / mid;
                    if(nums[i] % mid != 0){
                        tmp += 1;
                    }
                   person -= tmp;
                }
            }
            if(person < 0){
                // 사람이 음수라는 것 -> mid개로 나누어주려니까 더 많은 사람이 필요하다
                // mid개보다는 많이 나눠줘야된다.
                s = mid + 1;
                person = n;
            }else if(person >= 0){
                // 사람이 양수라는 것 -> mid개로 나눠줬는데도 사람이 남는다
                // mid개보다 더 적게 나눠줄 수 있다.
                e = mid - 1;
                person = n;
                result = mid;
            }
        }
        System.out.println(result);
    }
}