import java.util.*;
import java.io.*;
public class Main {
    public static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            String str = br.readLine();
            cnt =  1;
            if(check(str, 0)){
                System.out.println("1 " + cnt);
            }else{
                System.out.println("0 " + cnt);
            }

        }
    }
    public static boolean check(String str, int idx){ // str문자열이 팰린드롬인지 여부를 반환하는 함수
                                                // idx번째와 str.length() -1 - idx가 같은지 확인하는 함수
        if(idx == str.length() / 2){
            return true;
        }

        if(str.charAt(idx) != str.charAt(str.length() - 1 - idx)){
            return false;
        }else{
            cnt++;
            return check(str, idx+1);
        }

    }
}