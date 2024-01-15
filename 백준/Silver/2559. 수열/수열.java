import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            int num = sc.nextInt();
            prefix[i] = prefix[i-1] + num;
        }

        int result = prefix[k] - prefix[0];
        for(int i = k ; i <= n ; i++){
            result = result <= prefix[i] - prefix[i-k] ? prefix[i] - prefix[i-k] : result;
        }

        System.out.println(result);
    }
}