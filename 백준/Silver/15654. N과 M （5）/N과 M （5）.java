import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] selected;
    public static boolean[] used;
    public static int[] num;

    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        used = new boolean[N];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        p(0);
        System.out.println(sb);
    }
    public static void p(int m){
        if(m == M){
            for(int i : selected){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(used[i]){
                continue;
            }
            selected[m] = num[i];
            used[i] = true;
            p(m + 1);
            used[i] = false;
        }
    }
}