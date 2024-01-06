import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        arr[0] = 0;
        arr[1] = 3;


        for(int i = 1 ; i < 1001 ; i++){
            int cnt = 0;
            for(int j = 1 ; j <= i ; j++){
                if(i==j) continue;
                if(gcd(j,i) == 1){ // i와 j의 최대공약수가 1인가?
                    cnt++;
                }
            }
            arr[i] = arr[i-1] + cnt;
        }


        for(int testCase = 0 ; testCase < tc ; testCase++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n] * 2 + 1  + 2);

        }


    }

    private static int gcd(int a, int b) {
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;

    }

}