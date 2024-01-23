import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] appear;
        int result = 0;
        for(int tc = 0 ; tc < n ; tc++){
            String str = br.readLine();
            appear = new boolean[26];
            boolean possible = true;
            char before = str.charAt(0);

            appear[(int)before-'a'] = true;
            for(int i = 1 ; i < str.length() ; i++){
                if(before == str.charAt(i)){
                    continue;
                }else if(appear[(int)str.charAt(i)-'a']){
                    possible = false;
                    break;
                }else if(before != str.charAt(i)){
                    appear[(int)str.charAt(i)-'a'] = true;
                    before = str.charAt(i);
                }
            }
            if(possible){
//                System.out.println(str);
                result += 1;
            }
        }
        System.out.println(result);
    }
}