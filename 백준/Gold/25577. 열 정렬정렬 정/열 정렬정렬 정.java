import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] origin;
    public static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        origin = new int[n];
        sorted = new int[n];
        for(int i = 0 ; i < n ; i++){
            origin[i] = Integer.parseInt(st.nextToken());
            sorted[i] = origin[i];
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> position = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            position.put(sorted[i], i);
        }

        for(int i = 0 ; i < n ; i++){
            origin[i] = position.get(origin[i]);
        }

        boolean[] visited = new boolean[n];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(visited[i] || origin[i] == i){
                continue;
            }

            int len = 0;
            int cur = i;

            while(!visited[cur]){
                visited[cur] = true;
                len++;
                cur = origin[cur]; // 다음 인덱스
            }

            if(len > 0){
                cnt += (len - 1);
            }
        }

        System.out.println(cnt);



    }
}