import java.util.Scanner;

public class Main {
    public static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new Integer[n+1];
        dp[0] = dp[1] = 0;
        System.out.println(rec(n));
    }

    public static int rec(int num){
        if(dp[num] == null){
            if(num % 6 == 0){
                dp[num] = Math.min(rec(num/3),Math.min(rec(num/2), rec(num-1))) + 1;
            }
            else if(num % 3 == 0){
                dp[num] = Math.min(rec(num/3), rec(num-1)) + 1;
            }
            else if(num % 2 ==0){
                dp[num] = Math.min(rec(num/2), rec(num-1)) + 1;
            }
            else{
                dp[num] = rec(num-1) + 1;
            }
        }
        return dp[num];
    }
}