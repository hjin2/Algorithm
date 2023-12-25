import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[] arr = new int[n];


        for(int i = 0 ; i  < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n==1){
            System.out.println(0);
            return;
        }

        int result = 0;
        while(true){
            int max = -1;
            int maxCnt = 0;
            int maxIdx = -1;
            for(int i = 0 ; i < n ; i++){
                if(max < arr[i]){
                    max = arr[i];
                    maxIdx = i;
                    maxCnt = 1;
                }else if(max == arr[i]){
                    maxCnt++;
                }
            }

            if(maxCnt == 1 && arr[0] == max){
                break;
            }

            if(maxCnt > 1 && arr[0] == max){
                maxIdx++;
            }

            arr[maxIdx] -= 1;
            arr[0] += 1;
            result++;
        }
        System.out.println(result);
    }
}