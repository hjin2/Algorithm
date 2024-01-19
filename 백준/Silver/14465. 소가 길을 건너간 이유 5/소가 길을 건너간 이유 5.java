import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] prefix_sum = new int[n+1];
        for(int i = 0 ; i < b ; i++){
            int idx = Integer.parseInt(br.readLine());
            prefix_sum[idx] = 1;
        }

        for(int i = 1; i < n+1 ; i++){
            prefix_sum[i] = prefix_sum[i-1] + prefix_sum[i];
        }
        int min = 300000;
        for(int i = 1; i <= n-k+1 ; i++){
            if(prefix_sum[i+k-1] - prefix_sum[i-1] < min){
                min = prefix_sum[i+k-1] - prefix_sum[i-1];
            }
        }
        System.out.println(min);
    }
}