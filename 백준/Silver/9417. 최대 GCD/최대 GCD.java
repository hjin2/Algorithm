import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[100];
        for(int testcase = 0 ; testcase < n ; testcase++){
            st = new StringTokenizer(br.readLine());
            int result = Integer.MIN_VALUE;
            int idx = 0;
            while(st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                nums[idx++] = a;
            }

            for(int i = 0 ; i < idx ; i++){
                for(int j = i+1 ; j < idx ; j++){
                    int gcd = gcd(nums[i], nums[j]);
                    result = result < gcd ? gcd : result;
                }
            }
            System.out.println(result);
        }
    }

    public static int gcd(int a, int b){
        while(a % b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a > b ? b : a;
    }
}
