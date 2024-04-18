import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int[][] alphas;
    public static List<String> words = new ArrayList<>();
    public static List<String> boards = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("-")) {
                break;
            }
            words.add(str);
        }

        while (true) {
            String str = br.readLine();
            if (str.equals("#")) {
                break;
            }
            boards.add(str);
        }

        alphas = new int[words.size()][26];


        for (int i = 0; i < words.size(); i++) {
            // 단어들을 돌면서 알파벳을 모두 기록해놓는다.
            String pick = words.get(i);
            for (int j = 0; j < pick.length(); j++) {
                alphas[i][pick.charAt(j) - 'A']++;
            }
        }

        // 여기까지 리스트에 있는 알파벳들 다 저장완료
        /*출력
        for (int i = 0; i < alphas.length; i++) {
            for (int j = 0; j < 26; j++) {
                System.out.print(alphas[i][j] + " ");
            }
            System.out.println();
        }
        */


        for(int i = 0 ; i < boards.size() ; i++){
            int[] boardlist = new int[26]; // 해당 판에 알파벳 종류,갯수
            String nowboard = boards.get(i);
            for(int j = 0 ; j < nowboard.length() ; j++){
                boardlist[nowboard.charAt(j) - 'A']++;
            }

            // 해당 보드 판으로 단어를 만들 수 있는지 확인
            // 못만든다면 무시하기
            // 만들 수 있다면 해당 단어의 알파벳 카운팅
            int[] results = new int[26];
            for(int wordidx = 0 ; wordidx < words.size() ; wordidx++){
                if(canMake(wordidx, boardlist)) { // 못만들면 넘어가기
                    // 만들 수 있으면 해당 판으로 만든 단어의 알파벳이 몇개인지 누적해서 기록해야됨
                    boolean[] visited = new boolean[26];
                    for(int w = 0 ; w < words.get(wordidx).length() ; w++){
                        if(visited[words.get(wordidx).charAt(w) - 'A']) continue;
                        visited[words.get(wordidx).charAt(w) - 'A'] = true;
                        results[words.get(wordidx).charAt(w) - 'A']++;
                    }
                }
            }

            // 하나의 판으로 단어 디셔너리 다 확인했으니까 최솟값과 최댓값 구하기
            // 최솟값 구하기
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int k = 0 ; k < 26 ; k++){
                if(boardlist[k] == 0)continue;
                if(min > results[k]){
                    min = results[k];
                }
                if(max < results[k]){
                    max = results[k];
                }
            }

            // 최솟값 출력
            for(int k = 0 ; k < 26 ; k++){
                if(boardlist[k] == 0)continue;
                if(results[k] == min){
                    System.out.print((char)(65 + k));
                }
            }
            System.out.print(" " + min + " ");

            // 최댓값 출력
            for(int k = 0 ; k < 26 ; k++){
                if(boardlist[k] == 0)continue;
                if(results[k] == max){
                    System.out.print((char)(65 + k));
                }
            }
            System.out.println(" " + max);
        }
    }
    public static boolean canMake(int word , int[] board){
        // board판으로 word번째 단어를 만들 수 있는가?
        // board에 있는 알파벳 갯수 >= alpha[word][] 갯수가 같거나 크면 만들 수 있다.
        //           근데 하나라도 < 이면 아예 만들 수 없다.
        boolean possible = true;
        for(int i = 0 ; i < 26 ; i++){
            if(board[i] < alphas[word][i]){
                possible = false;
                return possible;
            }
        }
        return possible;
    }
}