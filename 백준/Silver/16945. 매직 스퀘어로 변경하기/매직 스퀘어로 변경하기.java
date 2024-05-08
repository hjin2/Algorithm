import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] input;
    public static int result = Integer.MAX_VALUE;
    public static int[][] arr;
    public static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        input = new int[3][3];
        arr = new int[3][3];
        visited = new boolean[10];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rec(0, 0);
        System.out.print(result);
    }
    public static void rec(int x, int y){
        if(y == 3){
            x += 1;
            y = 0;
        }
        if(x == 3 && y == 0){
            int sum = 0;
            if(magic()){
                for(int i = 0 ; i < 3 ; i++){
                    for(int j = 0 ;j  < 3 ; j++){
                        if(input[i][j] != arr[i][j]){
                            sum += Math.abs(input[i][j] - arr[i][j]);
                        }
                    }
                }
                result = sum < result ? sum : result;
            }
            return;
        }

        for(int i = 1 ; i <= 9 ; i++){
            if(visited[i]){
                continue;
            }
            arr[x][y] = i;
            visited[i] = true;
            rec(x, y + 1);
            visited[i] = false;
        }
    }
    public static boolean magic() {
        // 가로 합이 15인지 확인하기
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] + arr[i][1] + arr[i][2] != 15) {
                return false;
            }
        }

        // 세로 합이 15인지 확인하기
        for (int i = 0; i < 3; i++) {
            if (arr[0][i] + arr[1][i] + arr[2][i] != 15) {
                return false;
            }
        }


        if (arr[0][0] + arr[1][1] + arr[2][2] != 15) {
            return false;
        }

        if (arr[2][0] + arr[1][1] + arr[0][2] != 15) {
            return false;
        }
        return true;
    }
}