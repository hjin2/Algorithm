import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, total = 0;

        while (e < n) {
            total += nums[e];

            while (total > target) {
                total -= nums[s];
                s++;
            }

            if (total == target) {
                result++;
                total -= nums[s];
                s++;
            }

            e++;
        }

        System.out.println(result);
    }
}