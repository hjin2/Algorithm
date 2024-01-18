import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int total = 0;
        for(int i = 0 ; i < 9 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        Arrays.sort(arr);
        int target = total - 100;
        List<Integer> no = new ArrayList<>();

        int s = 0;
        int e = 8;
        while( s < e ){
            int sum = arr[s] + arr[e];
            if(sum < target){
                s++;
            }else if ( sum > target ){
                e--;
            }else{
                no.add(s);
                no.add(e);
                break;
            }
        }

        for(int i = 0 ; i < 9 ; i++){
            if(!no.contains(i)){
                System.out.println(arr[i]);
            }
        }

    }
}