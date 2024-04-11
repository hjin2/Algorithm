import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int result = 0;
    public static int n;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        // 2 * n 크기의 직사각형을 1 * 2, 2 * 1 타일로 채우는 방법의 수
        // 행 * 열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[1001];
        // 2 * n(행)

        arr[1] = 1; // 열의 길이가 1일 때 생기는 경우의 수 : 1
        arr[2] = 2; // 열의 길이가 2일 때 생기는 경우의 수 : 2


        for(int i = 3 ; i < n ; i++){
            rec(i);
        }
        System.out.println(rec(n));
//        System.out.println(result);
    }
    public static int rec(int col){ // 열의 길이가 col일 때 생기는 경우의 수
        if(col == 1){
            return arr[1];
        }else if(col == 2){
            return arr[2];
        }
        return arr[col] = ((arr[col-1]) + (arr[col-2]))%10007;
    }
}