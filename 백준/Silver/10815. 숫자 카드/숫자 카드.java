import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] exist = new int[n];
        for(int i = 0 ; i < n ; i++){
            exist[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] find = new int[m];
        for(int i = 0 ; i < m ; i++){
            find[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(exist);

        for(int i = 0 ; i < m ; i++){
            int s = 0;
            int e = n-1;
            int mid;
            int result = 0;
            while( s <= e ){
                mid = (s + e) / 2;
                if(exist[mid] == find[i]){
                    result = 1;
                    break;
                }
                else if(exist[mid] < find[i]){
                    s = mid + 1;
                }else{
                    e = mid - 1;
                }
            }
            System.out.print(result + " " );
        }

    }
}