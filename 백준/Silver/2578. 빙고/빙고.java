import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr = new int[5][5];
    public static boolean[][] visited = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i = 0 ; i < 5 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 5 ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < 5 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 5 ; j++){
                erase(Integer.parseInt(st.nextToken()));
                if(bingo()){ // 빙고이면
                    System.out.println(cnt + 1);
                    System.exit(0);
                    break;
                }else{
                    cnt++;
                }
            }
        }


    }
    public static void erase(int num){
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(arr[i][j] == num){
                    visited[i][j] = true;
                }
            }
        }
    }
    public static boolean bingo(){
        int cnt = 0;
        for(int i = 0 ; i < 5 ; i++){
            boolean garo = true;
            for(int j = 0 ; j < 5 ; j++){
                if(!visited[i][j]){ // 하나라도 false인 경우
                    garo = false;
                    break; // 다음줄로 넘어가기
                }
            }
            if(garo){
                cnt++;
            }
        }

        for(int i = 0 ; i < 5 ; i++){
            boolean sero = true;
            for(int j = 0 ; j < 5 ; j++){
                if(!visited[j][i]){ // 하나라도 false인 경우
                    sero = false;
                    break; // 다음줄로 넘어가기
                }
            }
            if(sero){
                cnt++;
            }
        }

        boolean diag = true;
        for(int i = 0 ; i < 5 ; i++){
            if(!visited[i][i]){ // false이면
                diag = false;
            }
        }
        if(diag){
            cnt++;
        }

        boolean diagr = true;
        for(int i = 0 ; i < 5 ; i++){
            if(!visited[i][4 - i]){ // false이면
                diagr = false;
            }
        }
        if(diagr){
            cnt++;
        }

        if(cnt >= 3){
            return true;
        }else{
            return false;
        }
    }
}