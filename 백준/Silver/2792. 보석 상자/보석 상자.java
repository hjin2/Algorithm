import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] colorsCnt = new int[m];
        for(int i = 0 ; i<m;i++){
            colorsCnt[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(colorsCnt);
        int left = 1;
        int right = colorsCnt[m-1];
        

        while(left <= right){
            int mid = (left+right) / 2;
            int sum = 0;

            int person = 0;
            for(int i = 0 ; i < m ; i++){
                if(colorsCnt[i] % mid ==0 ){
                    person += colorsCnt[i] / mid;
                }else{
                    person += colorsCnt[i] / mid +1;
                }
            }

            if(person >  n){
               left = mid + 1;
            }else{
                right = mid -1;
                result = mid;
            }
        }

        System.out.println(result);


    }
}