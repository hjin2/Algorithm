import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, L, R, X;
    public static int[] selected;
    public static int[] score;
    public static boolean[] used;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        score = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 2; i <= N ; i++){
            used = new boolean[N];
            selected = new int[i];
            combi(N,i,0, 0);
        }
        System.out.println(result);
    }
    public static void combi(int n, int r, int m, int start){
        if(m == r){
            // nCr개 다 뽑았다는 뜻
            int total = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i =0 ; i < r ; i++){
                min = min > selected[i] ? selected[i] : min;
                max = max < selected[i] ? selected[i] : max;
                total += selected[i];
            }


            if(L <= total && total <= R && (max - min) >= X){
                result++;
            }
            return;
        }

        for(int i = start ; i < n ; i++){
            if(used[i]){
                continue;
            }
            selected[m] = score[i];
            used[i] = true;
            combi(n, r, m + 1, i + 1);
            used[i] = false;
        }
    }
}