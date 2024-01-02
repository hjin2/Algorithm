import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int k = 100 - y - 10 ; k < 100 - y ; k++){
                for(int l = x ; l < x + 10 ; l++){
                    arr[k][l] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < 100 ; i++){
            for(int j = 0 ; j < 100 ; j++){
//                System.out.print(arr[i][j] + " ");
                if(arr[i][j] == 1){
                    cnt++;
                }
            }
//            System.out.println();
        }
        System.out.println(cnt);

    }
}