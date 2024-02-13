import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] sum;
    static int[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int size = 100000 * 20 + 1;
        sum  = new boolean[size];

        s = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(s);


        recur(0, 0);
        for(int i  = 1 ; i <= size ; i++){
            if(!sum[i]){
                System.out.println(i);
                break;
            }
        }

    }
    public static void recur(int rec, int total){
//        System.out.printf("rec : %d    total : %d\n", rec, total);
        if(rec == n){
            sum[total] = true;
            return;
        }

        recur(rec + 1, total + s[rec]);

        recur(rec + 1, total);
    }
}