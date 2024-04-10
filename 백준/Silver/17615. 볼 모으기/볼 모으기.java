import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        int result = Integer.MAX_VALUE;

        // 빨간색을 가장 왼쪽으로 모으는 경우
        // 맨 왼쪽에 빨간색이 바로 나오는 경우 : 왼쪽 빨간색 무리가 끊기는 순간부터 뒤에 나오는 애들 중 빨간색 갯수
        // 맨 왼쪽에 빨간색이 바로 안나오는 경우 (파란색 나오고 빨간색 나오는 경우) : 무조건 뒤에 나오는 빨간색 갯수
        int leftB = 0;
        int cnt = 0;
        for(int i = 0 ; i < len ; i++){
            if(str.charAt(i) == 'B'){
                // i번째 인덱스가 파란색이면 i개가 빨간색이 있다는 뜻
                leftB = i;
                break;
            }
        }
        for(int i = leftB ; i < len ; i++){
            if(str.charAt(i) == 'R'){
                cnt++;
            }
        }
        result = Math.min(cnt, result);

        // 빨간색을 가장 오른쪽으로 모으는 경우
        int rightB = 0; // 오른쪽영역부터 시작했을 때, 처음으로 파란색이 나오는 순간
        cnt = 0;
        for(int i = len - 1; i >= 0 ; i--){
            if(str.charAt(i) == 'B'){
                rightB = i;
                break;
            }
        }
        for(int i = rightB ; i >= 0 ; i--){
            if(str.charAt(i) == 'R'){
                cnt++;
            }
        }
        result = Math.min(cnt, result);


        // 파란색을 가장 왼쪽으로 모으는 경우
        // 처음부터 파란색이 나오는 경우
        // 빨간색이 먼저 나오는 경우
        int leftR = 0;
        cnt = 0;
        for(int i = 0 ; i < len ; i++){
            if(str.charAt(i) == 'R'){
                leftR = i;
                break;
            }
        }
        for(int i = leftR ; i < len ; i++){
            if(str.charAt(i) == 'B'){
                cnt++;
            }
        }
        result = Math.min(cnt, result);


        // 파란색을 가장 오른쪽으로 모는 경우
        int rightR = 0;
        cnt = 0;
        for(int i = len - 1 ; i >= 0 ; i--){
            if(str.charAt(i) == 'R'){
                rightR = i;
                break;
            }
        }
        for(int i = rightR ; i >= 0 ; i--){
            if(str.charAt(i) == 'B'){
                cnt++;
            }
        }
        result = Math.min(cnt, result);

        System.out.println(result);
    }
}