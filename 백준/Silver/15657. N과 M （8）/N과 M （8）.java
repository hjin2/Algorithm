import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] selected;
    static int[] candi;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();

        candi = new int[n];
        selected = new int[m];
        for(int i = 0 ; i < n; i++){
            candi[i] = sc.nextInt();
        }

        Arrays.sort(candi);

        rec(0,0);
        System.out.println(sb);
    }
    public static void rec(int depth, int startidx){
        if(depth == m){
            for(int num : selected){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = startidx ; i < n ; i++){
            selected[depth] = candi[i];
            rec(depth + 1, i);
        }
    }
}