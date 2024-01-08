import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[n+1];
//        arr[1] = 1;
//        for(int i = 2 ; i <= n ; i++){
//            int cnt = 0; // 약수의 개수
//            for(int j = 1 ; j <= Math.sqrt(i) ; j++){
//                if( i % j == 0){
//                    cnt++;
//                    if( i / j != j){
//                        cnt++;
//                    }
//                }
//            }
//            arr[i] = cnt;
//        }

//        int white = 0;
//        for(int i = 1; i <= Math.sqrt(n) ; i++){
////            if(arr[i] % 2 != 0){
////                white++;
////            }
//            if((int)Math.sqrt(i) * (int)Math.sqrt(i) == i){
////                System.out.println(i);
//                white++;
//            }
//        }
        System.out.println((int)Math.sqrt(n));
    }

}