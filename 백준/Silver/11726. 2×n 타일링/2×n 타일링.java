import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int result = 0;
    public static int n;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        // 2 * n 크기의 직사각형을 1 * 2, 2 * 1 타일로 채우는 방법의 수
        // 행 * 열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());            // 2 * n(행)
        dp = new int[1001]; // 크기 최대로 만들어놓기


        dp[1] = 1; // 열의 길이가 1일 때 생기는 경우의 수 : 1
        dp[2] = 2; // 열의 길이가 2일 때 생기는 경우의 수 : 2


        for (int i = 3; i <= n; i++) {
//            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
            rec(i);
        }
        System.out.println(dp[n]);
    }

    public static int rec(int col) { // 열의 길이가 col일 때 생기는 경우의 수
        if (col == 1) {
            return dp[1];
        } else if (col == 2) {
            return dp[2];
        }
        return dp[col] = (dp[col-2] + dp[col-1]) % 10007;
    }
}