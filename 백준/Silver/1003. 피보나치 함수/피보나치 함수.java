import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] count = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        fibo();
        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(count[num][0] + " " + count[num][1]);
        }
    }

    public static void fibo() { // num을 호출할 때 0과 1이 몇번 호출되는지 출력
        count[0][0] = 1;
        count[0][1] = 0;
        count[1][0] = 0;
        count[1][1] = 1;

        for (int num = 2; num <= 40; num++) {
            count[num][0] = count[num - 2][0] + count[num - 1][0];
            count[num][1] = count[num - 2][1] + count[num - 1][1];
        }
    }
}