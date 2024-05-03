import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static boolean[] used = new boolean[11];
    public static int total = 0;
    public static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < tc ; i++){
            total = 0;
            result = -1;
            arr = new int[11][11];

            for(int k = 0 ; k < 11 ; k++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 11 ; j++){
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 여기있는 11명을 다 써야됨
            // 대신 0인 능력은 쓰면 안됨

            rec(0);
            System.out.println(result);
        }
    }
    public static void rec(int n){
        if(n == 11){
            result = result < total ? total : result;
            return;
        }

        for(int i = 0 ; i < 11 ; i++){
            if(used[i]){
                continue;
            }
            if(arr[n][i] == 0){
                continue; // n번째 사람의 능력이 0이면 pass
            }
            total += arr[n][i];
            used[i] = true;
            rec(n + 1);
            used[i] = false;
            total -= arr[n][i];
        }

    }
}