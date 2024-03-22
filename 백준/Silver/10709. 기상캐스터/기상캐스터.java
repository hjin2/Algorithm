import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] arr = new int[x][y];

        for(int i = 0 ; i < x ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < y ; j++){
                if(str.charAt(j) == 'c'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = -1;
                }
            }
        }

        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if(arr[i][j] == 0){
                    int nxt = j + 1;
                    int cnt = 1;
                    while(nxt < y && arr[i][nxt] == -1){
                        arr[i][nxt] = cnt;
                        cnt++;
                        nxt++;
                    }
                }
            }
        }

        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }



    }
}