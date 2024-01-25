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
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] target = new int[m];
        for(int i = 0 ; i < m ; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        for(int i = 0 ; i < m ; i++){
            int s = 0;
            int e = n-1;
            int mid;
            boolean exist = false;
            while(s <= e){
                mid = (s + e) / 2;
                if(a[mid] < target[i]){
                    s = mid + 1;
                }else if(a[mid] > target[i]){
                    e = mid - 1;
                }else{
                    exist = true;
                    break;
                }
            }
            if(exist){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }
}