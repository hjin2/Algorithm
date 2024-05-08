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
        int[] boxs = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            boxs[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        Arrays.fill(dp,1);

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(boxs[j] < boxs[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}