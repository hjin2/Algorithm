import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        arr = null;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());


            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int cnt = 0;
            for (int a = 0; a < n - 2; a++) {
                for (int b = a+1; b < n - 1; b++) {
                    int target = arr[b] - arr[a];
                    if (exist(arr[b] + target, b)) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }
    public static boolean exist(int target, int b){
        int s = b;
        int e = arr.length - 1;
        int mid;
        while( s <= e ){
            mid = (s + e) / 2;
            if(arr[mid] < target){
                s = mid + 1;
            }else if(arr[mid] > target){
                e = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}