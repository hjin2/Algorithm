import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] arr = new char[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0 ; i < 10 ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < 10 ; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                if(arr[i][j] != '.') continue;
                if( chk(i,j) ){
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);


    }

    private static boolean chk(int x, int y) {
        // 가로
        int cnt = 0;
        for(int i = 1 ; i < 5 ; i++){
            if(y + i >= 10) break;
            if(arr[x][y+i] == 'X'){
                cnt++;
            }
            if(arr[x][y+i] == 'O' || arr[x][y+i] == '.'){
                break;
            }
        }




        for(int i = 1 ; i < 5 ; i++){
            if(y - i < 0) break;
            if(arr[x][y - i] == 'X'){
                cnt++;
            }
            if(arr[x][y - i] == 'O' || arr[x][y - i] == '.'){
                break;
            }
        }
        if(cnt >= 4) return true;

        // 세로
        cnt = 0;
        for(int i = 1 ; i < 5 ; i++){
            if(x + i >= 10) break;
            if(arr[x + i][y] == 'X'){
                cnt++;
            }
            if(arr[x + i][y] == 'O' || arr[x + i][y] == '.'){
                break;
            }
        }

        for(int i = 1 ; i < 5 ; i++){
            if(x - i < 0) break;
            if(arr[x - i][y] == 'X'){
                cnt++;
            }
            if(arr[x - i][y] == 'O' || arr[x - i][y] == '.'){
                break;
            }
        }
        if(cnt >= 4) return true;

        //  "/"
        cnt = 0;
        for(int i = 1 ; i < 5 ; i++){
            if(x - i < 0 || y + i >= 10) break;
            if(arr[x - i][y + i] == 'X'){
                cnt++;
            }
            if(arr[x - i][y + i] == 'O' || arr[x - i][y + i] == '.'  ) {
                break;
            }
        }

        for(int i = 1 ; i < 5 ; i++){
            if(x + i >= 10 || y - i < 0) break;
            if(arr[x + i][y - i] == 'X'){
                cnt++;
            }
            if(arr[x + i][y - i] == 'O' || arr[x + i][y - i] == '.'){
                break;
            }
        }
        if(cnt >= 4) return true;

        // "\"
        cnt = 0;
        for(int i = 1 ; i < 5 ; i++){
            if(x + i >= 10 || y + i >= 10) break;
            if(arr[x + i][y + i] == 'X'){
                cnt++;
            }
            if(arr[x + i][y + i] == 'O' || arr[x + i][y + i] == '.'){
                break;
            }
        }

        for(int i = 1 ; i < 5 ; i++){
            if(x - i < 0 || y - i < 0) break;
            if(arr[x - i][y - i] == 'X'){
                cnt++;
            }
            if(arr[x - i][y - i] == 'O' || arr[x - i][y - i] == '.'){
                break;
            }
        }
        if(cnt >= 4) return true;

        return false;

    }


}