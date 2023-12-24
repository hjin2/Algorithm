import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[] arr = new int[1001];
        int n = Integer.parseInt(br.readLine());

        int maxleft = -1;
        int maxright = -1;
        int max = -1;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr[idx] = length;
            if(max < length){ // 아예 최댓값 갱신
                max = length;
                maxleft = idx;
                maxright = idx;
            }else if(max == length) {
                if (maxleft < idx && maxright < idx) {
                    maxright = idx;
                }
            }
        }


        for(int i = 1 ; i < maxright ; i++){
            if(arr[i] >= arr[i+1]){
                arr[i+1] = arr[i];
            }
        }
        for(int i = 1000 ; i > maxright + 1 ; i-- ){
            if(arr[i] >= arr[i-1]){
                arr[i-1] = arr[i];
            }
        }

        int sum = 0;
        for(int i = 0 ; i < 1001 ; i++){
//            System.out.println( i + " : " + arr[i] + " " );
            sum += arr[i];
        }
        System.out.println(sum);


    }
}