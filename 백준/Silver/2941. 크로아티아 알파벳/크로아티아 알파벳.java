import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 구하고 싶은 것은 n글자의 단어가 주어질 때 크로아티아 알파벳은 몇 개가 있는가?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        /*
        가장 처음 생각난 것
        c일때 다음꺼 확인하기
        d일때 다음 두자리 확인하기
        l일때 다음꺼 확인하기
        n일때 다음꺼 확인하기
        s일때 다음꺼 확인하기
        z일때 다음꺼 확인하기
         */

        int result = 0;
        int length = str.length();
        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);

            if(c == 'c'){ // 1. c= 혹은 c-가 아닐때 c를 안세아리고 그냥 넘어가버림
                if(i+1 < length && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-')){ // 2. StringIndexOutOfBounds 범위 넘어가버림
                    result++;
                    i++; // 한칸 pass
                }else{
                    result++;
                }
            }else if(c == 'd'){
                if(i+1 < length && str.charAt(i+1) == '-'){
                    result++;
                    i++; // 한칸 더 패스
                }else if(i+ 2 < length && str.charAt(i+1) == 'z' && str.charAt(i+2) == '='){
                    result++;
                    i += 2;
                }else{
                    result++;
                }
            }else if(c == 'l'){
                if(i+1 < length && str.charAt(i + 1) == 'j'){
                    result++;
                    i++;
                }else{
                    result++;
                }
            }else if(c == 'n'){
                if(i+1 < length && str.charAt(i + 1) == 'j'){
                    result++;
                    i++;
                }else{
                    result++;
                }
            }else if(c == 's' || c == 'z'){
                if(i+1 < length && str.charAt(i + 1) == '='){
                    result++;
                    i++;
                }else{
                    result++;
                }
            }else{
                result++;
            }
        }
        System.out.println(result);

    }
}