import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        comb(0);
        System.out.println(sb);
    }
    public static void comb(int depth){
        if(depth == m){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i <= n ; i++){
            arr[depth] = i;
            comb(depth + 1);
        }
    }
}
