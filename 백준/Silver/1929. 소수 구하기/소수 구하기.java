import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        /*
        소수 어떻게 구하지?
        에라토스 어쩌구 체..?
        소수 : 1과 자기 자신으로 나누어지는 수

        1. 전체 다 소수이다.
        2. 소수인 곳이면 백만까지 돌면서 나랑 나누어지는지 확인하기
         */
        boolean[] sosu = new boolean[1000001];
        
        for(int i = 2 ; i < 1000001 ; i++){
            sosu[i] = true;
        }

        for(int i = 2;  i < Math.sqrt(1000001) ; i++){
            if(sosu[i]){
                for(int j = i * i ; j < 1000001 ; j++){
                    if(!sosu[j])continue;
                    if(j % i == 0){
                        sosu[j] = false;
                    }
                }
            }
        }

        for(int i = s ; i <= e ; i++){
            if(sosu[i]){
                System.out.println(i);
            }
        }
    }
}