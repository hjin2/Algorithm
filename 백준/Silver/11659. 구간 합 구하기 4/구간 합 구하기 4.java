import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] suffix_sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            suffix_sum[i] = suffix_sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int tc = 0 ; tc < m ; tc++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(suffix_sum[b] - suffix_sum[a-1]);

        }
    }
}