import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int result = 0; // 친구 수
    public static int n; // 동기 수
    public static int m; // 친구 리스트 길이
    public static List<List<Integer>> relation = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            relation.add(new ArrayList<>());
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        dfs(1);
        System.out.println(result);
    }

    public static void dfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if(cnt < 2) {
                while (size-- > 0) {
                    int top = queue.poll();
                    for (int i = 0; i < relation.get(top).size(); i++) {
                        int next = relation.get(top).get(i); // 1번과 친구인 애들
                        if (visited[next]) {
                            continue;
                        }
                        visited[next] = true; // 친구인 애들 친구목록에 넣기
                        queue.add(next);
                        result++;
                    }
                }
                cnt++;
            }else{
                return;
            }
        }
    }

}
