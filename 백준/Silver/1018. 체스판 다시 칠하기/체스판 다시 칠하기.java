import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static char[][] input;
    public static char[][] answerW;
    public static char[][] answerB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열

        input = new char[n][m];
        answerW = new char[n][m];
        answerB = new char[n][m];

        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < m ; j++){
                input[i][j] = str.charAt(j);
            }
        }

        // White
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i % 2 == 0){
                    if(j % 2 == 0){
                        answerW[i][j] = 'W';
                    }else{
                        answerW[i][j] = 'B';
                    }
                }else{
                    if(j % 2 == 0){
                        answerW[i][j] = 'B';
                    }else{
                        answerW[i][j] = 'W';
                    }
                }
            }
        }

        // Black
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i % 2 == 0){
                    if(j % 2 == 0){
                        answerB[i][j] = 'B';
                    }else{
                        answerB[i][j] = 'W';
                    }
                }else{
                    if(j % 2 == 0){
                        answerB[i][j] = 'W';
                    }else{
                        answerB[i][j] = 'B';
                    }
                }
            }
        }


        int result = Integer.MAX_VALUE;
        for(int startx = 0 ; startx <= n - 8 ; startx++){
            for(int starty = 0 ; starty <= m - 8 ; starty++){
                int cnt = 0; // 8*8 했을 때 몇 개 고쳐야하는지
                for(int i = startx ; i < startx + 8 ; i++){
                    for(int j = starty ; j < starty + 8 ; j++){
                        if(input[i][j] != answerW[i][j]){
                            cnt++;
                        }
                    }
                }
                result = result > cnt ? cnt : result;
            }
        }

        for(int startx = 0 ; startx <= n - 8 ; startx++){
            for(int starty = 0 ; starty <= m - 8 ; starty++){
                int cnt = 0; // 8*8 했을 때 몇 개 고쳐야하는지
                for(int i = startx ; i < startx + 8 ; i++){
                    for(int j = starty ; j < starty + 8 ; j++){
                        if(input[i][j] != answerB[i][j]){
                            cnt++;
                        }
                    }
                }
                result = result > cnt ? cnt : result;
            }
        }

        System.out.println(result);

    }

}