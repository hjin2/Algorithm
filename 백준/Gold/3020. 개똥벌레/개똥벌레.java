import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] prefix_sum = new int[h+1];
        for(int i = 0 ; i < n ; i++){
            int idx = Integer.parseInt(br.readLine());
            if(i % 2 == 0){ // 석순일 때
                prefix_sum[1]++;
                prefix_sum[idx+1]--;
            }else{ // 종유석일 때
                prefix_sum[h-idx+1]++;
            }
        }
        int minimum = Integer.MAX_VALUE;
        for(int i = 1 ; i <= h ; i++){
            prefix_sum[i] = prefix_sum[i-1] + prefix_sum[i];
            minimum = prefix_sum[i] < minimum ? prefix_sum[i] : minimum;
        }

        int cnt = 0;
        for(int i = 1 ; i <= h ; i++){
            if(prefix_sum[i] == minimum){
                cnt++;
            }
        }
        System.out.println(minimum + " " + cnt);


    }
}