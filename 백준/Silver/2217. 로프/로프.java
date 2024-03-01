import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = Integer.MIN_VALUE;
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // 가장 작은 수 * N = w 일때 w / k 했을 때 가장 작은수가 통과하니까 나머지도 다 ok
        // 근데 모든 로프를 사용할 필요는 없다.
//        System.out.println(arr[0] * N);

        for(int i = 0 ; i < N ; i++){
            result = (arr[i] * (N-i)) > result ? (arr[i] * (N-i)) : result;
        }
        System.out.println(result);

    }
}