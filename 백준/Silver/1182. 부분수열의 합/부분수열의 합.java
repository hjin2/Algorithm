import java.util.Scanner;

public class Main {
    static int N,S;
    static StringBuilder sb;
    static int[] nums;
    static int result;
    static int[] selected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // n개의 정수로 이루어진 수열
        S = sc.nextInt(); // 합이 s가 되어야함

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        recur(0,0);
        if(S == 0){
            System.out.println(result - 1); // 모두 선택하지 않은 경우
        }else {
            System.out.println(result);
        }
    }
    public static void recur(int depth , int total){
        if(depth == N){
            if(total == S){
                result += 1;
            }
            return;
        }

        // 고르는 경우
        recur(depth + 1, total + nums[depth]);

        // 안고르는 경우
        recur(depth + 1, total);


    }
}