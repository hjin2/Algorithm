import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] usedalpha = new boolean[2000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            String words = br.readLine();
            String upperwords = words.toUpperCase();
            boolean finish = false;
            for(int j = 0 ; j < words.length() ; j++){
                if(j == 0) {
                    if (!usedalpha[upperwords.charAt(0) - 'A']) {
                        usedalpha[upperwords.charAt(0) - 'A'] = true; // 사용했다고 적기
                        print(0, words); // 0번째에 괄호 넣어서 글자 출력하기
                        System.out.println();
                        finish = true;
                        break;
                    }
                }else{
                    if(words.charAt(j) != ' ' && words.charAt(j - 1) == ' '){
                        // 여기가 지금 단어의 첫 글자이다.
                        if (!usedalpha[upperwords.charAt(j) - 'A']) {
                            usedalpha[upperwords.charAt(j) - 'A'] = true; // 사용했다고 적기
                            print(j, words); // 0번째에 괄호 넣어서 글자 출력하기
                            System.out.println();
                            finish = true;
                            break;
                        }
                    }
                }
            }
            if(!finish){
                // finish가 여기서 false이면 단어 첫글자 다 확인했는데 정답 없는거니까
                // 다시 처음부터 돌면서 정답되는거 있는지 확인
                for(int k = 0 ; k < words.length() ; k++){
                    if(words.charAt(k) != ' ' && !usedalpha[upperwords.charAt(k) - 'A']){
                        usedalpha[upperwords.charAt(k) - 'A'] = true;
                        print(k, words); // k번째 괄호 넣어서 글자 출력하기
                        System.out.println();
                        finish = true;
                        break;
                    }
                }
                if(!finish){
                    System.out.println(words);
                }
            }
        }

    }
    public static void print(int idx, String words){
        for(int i = 0 ; i < words.length() ; i++){
            if(i == idx){
                System.out.print("[");
                System.out.print(words.charAt(i) + "]");
            }else{
                System.out.print(words.charAt(i));
            }
        }
    }
}