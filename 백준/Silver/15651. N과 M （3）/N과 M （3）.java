import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[] selected;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        selected = new int[M];
        // 중복순열
        /*
        11
        12
        13
        14
        21
        22
        23
        24
        31
        32
        33
        34
        41
        42
        43
        44
         */

        p(0);
        System.out.println(sb);
    }

    public static void p(int m){
        if(m == M){
            for(int i = 0 ; i < m ; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1 ; i <= N ; i++){
            selected[m] = i;
            p(m + 1);
        }
    }
}