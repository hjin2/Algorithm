import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            long num = Long.parseLong(br.readLine());
            if(secret(num)){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }

    public static boolean secret(long num){
        // 소수들의 곱으로 이루어졌는가?
        // 1부터 1,000,000을 돌면서 나누어 떨어질때, 그 나누어 떨어지게 한 수가 소수인지 확인하자.
        boolean possible = false;
        for(int i =  2 ; i <= 1000000 ; i++){
            if(num % i == 0){
                if(sosu(i)){ // 소수이면
                    possible = true;
                }
            }
        }
        return possible;
    }

    private static boolean sosu(int i) {
        boolean sosu = true;
        for(int a = 2 ; a < i ; a++){
            if(i % a == 0){
                sosu = false;
            }
        }

        return sosu;
    }
}