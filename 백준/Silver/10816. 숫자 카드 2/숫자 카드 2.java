import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] exist = new int[n];
        for (int i = 0; i < n; i++) {
            exist[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(exist);
        while(st.hasMoreTokens()){
            int x = Integer.parseInt(st.nextToken());

            // 1. x이상의 값이 처음으로 나타나는 위치를 구한다
            int lowerBoundIndex = findLowerBoundIndex(exist, x);

            // 2. x 초과의 값이 처음으로 나타나는 위치를 구한다.
            int upperBoundIndex = findUpperBoundIndex(exist, x);

            // 3. 두 값을 이용해 x의 개수를 센다
            bw.write(upperBoundIndex - lowerBoundIndex + " ");
        }
        bw.write("\n");
        bw.flush();




        }

    private static int findUpperBoundIndex(int[] arr, int x) {
        int upperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(arr[m] <= x ){
                l = m + 1;
            }else{
                r = m - 1;
                upperBoundIndex = m;
            }
        }
        return upperBoundIndex;
    }



    private static int findLowerBoundIndex(int[] arr, int x) {
        int lowerBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(arr[m] < x){
                l = m + 1;
            }else{
                r = m - 1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }
}