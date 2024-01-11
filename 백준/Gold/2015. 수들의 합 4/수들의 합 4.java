import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

        static int n, k;
        static int arr[];
        static Map<Integer, Long> map = new HashMap<>();
        static StringTokenizer st;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n + 1];

            long answer = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
                if (arr[i] == k) {
                    answer++;
                }
                if (map.containsKey(arr[i] - k))
                    answer += map.get(arr[i] - k);
                if (!map.containsKey(arr[i]))
                    map.put(arr[i], 1L);
                else
                    map.put(arr[i], map.get(arr[i]) + 1);
            }

            System.out.println(answer);
        }
    }