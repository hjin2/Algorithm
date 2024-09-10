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

        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nums[i]);
        }

        int s = 1;
        int e = max;
        int mid;

        while (s <= e) {
            mid = (s + e) / 2;
            int person = n; // 매번 새롭게 초기화

            // 최대 mid개만큼 나누어줄 것이다.
            for (int i = 0; i < m; i++) {
                if (nums[i] <= mid) {
                    person -= 1;
                } else { // nums[i] > mid
                    int tmp = nums[i] / mid;
                    if (nums[i] % mid != 0) {
                        tmp += 1;
                    }
                    person -= tmp;
                }
            }

            if (person < 0) {
                // 사람이 음수라는 것 -> mid개로 나누어주려니까 더 많은 사람이 필요하다
                s = mid + 1;
            } else {
                // 사람이 충분하거나 남을 수 있다 -> mid보다 더 적게 나눠줄 수 있다
                e = mid - 1;
                result = mid; // 최적의 mid 값 저장
            }
        }

        System.out.println(result);
    }
}