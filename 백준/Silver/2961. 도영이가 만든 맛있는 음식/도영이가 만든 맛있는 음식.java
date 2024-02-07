import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static Long[] a ,b;
    public static Long min = Long.MAX_VALUE;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        a = new Long[N];
        b = new Long[N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(st.nextToken());
            b[i] = Long.parseLong(st.nextToken());
        }

        comb(0, 1L, 0L);
        System.out.println(min);
    }
    public static void comb(int depth, Long asum, Long bsum){
        if(depth == N){
            if(asum == 1 && bsum == 0){
                return;
            }
            if(Math.abs(asum - bsum) <= min){
                min = Math.abs(asum - bsum);
            }
            return;
        }

        comb(depth + 1, asum * a[depth], bsum + b[depth]);

        comb(depth + 1, asum, bsum);
    }
}