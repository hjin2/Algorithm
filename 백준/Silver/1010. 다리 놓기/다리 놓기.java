import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static BigInteger[] results = new BigInteger[30];
    public static void main(String[] args) throws IOException {
        results[1] = BigInteger.valueOf(1);
        results[0] = BigInteger.valueOf(1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        fac(29);


        for (int tc = 0; tc < testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // mCn = m! / n! (m-n)!
            System.out.println(results[m].divide(results[n]).divide(results[m - n]));

        }

    }

    public static BigInteger fac(int n){ // 1에서 n까지의 곱 : n * n-1 * n-2 .. * 3 * 2 * 1
        if(n == 1){
            return BigInteger.valueOf(1);
        }
        return results[n] = fac(n - 1).multiply(BigInteger.valueOf(n));
    }
}