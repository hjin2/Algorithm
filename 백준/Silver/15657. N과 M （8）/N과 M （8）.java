import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] selected;

    public static int[] num;

    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        c(0, 0);
        System.out.println(sb);
    }
    public static void c(int m, int start){
        if(m == M){
            for(int i : selected){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start ; i < N ; i++){
            selected[m] = num[i];
            c(m + 1, i);
        }
    }
}