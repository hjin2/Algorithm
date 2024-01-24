import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] exist = new int[n];

        for(int i = 0 ; i < n ; i++){
            exist[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(exist);
        for(int i = 0  ; i < n ; i++){
            System.out.println(exist[i]);
        }
    }
}
