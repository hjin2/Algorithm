import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] prefix_sum = new int[w+1];
        int[] suffix_sum = new int[w+1];
        int[] min_sum = new int[w+1];
        int[] ws = new int[w+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= w ; i++){
            ws[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= w ; i++){
            if(ws[i] > prefix_sum[i-1]){
                prefix_sum[i] = ws[i];
            }else{
                prefix_sum[i] = prefix_sum[i-1];
            }
        }

        suffix_sum[w] = ws[w];
        for(int i = w-1 ; i > 0 ; i--){
            if(ws[i] > suffix_sum[i+1]){
                suffix_sum[i] = ws[i];
            }else{
                suffix_sum[i] = suffix_sum[i+1];
            }
        }

        for(int i = 1; i <= w ; i++){
            if(prefix_sum[i] <= suffix_sum[i]){
                min_sum[i] = prefix_sum[i];
            }else{
                min_sum[i] = suffix_sum[i];
            }
        }
        
        // 양쪽에 나보다 큰게 있을 때
        // 양 두 수 중 작은 수 - 1

        int result = 0;
        for(int i = 1; i <= w ; i++){
            if(ws[i] < min_sum[i]){
                result += min_sum[i] - ws[i];
            }
        }

        System.out.println(result);
    }
}