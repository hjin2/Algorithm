import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited = new boolean[1000001];
    public static int result = 0;
    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        queue.add(n);
        visited[n] = true;

        bfs();
        System.out.println(result - 1);

    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            while (size-- > 0) {
                int pick = queue.poll(); // queue에 있는거 하나 뽑기
                if (pick == k) {
                    // 내가 뽑은게 k일 때 멈추기 !
                    return;
                }

                int[] adj = {pick - 1, pick + 1, pick * 2};

                for (int i = 0; i < 3; i++) {
                    if (adj[i] < 0 || adj[i] > 100000) {
                        continue; // 범위를 벗어나면 그냥 넘어가기
                    }
                    if (visited[adj[i]]) {
                        continue; // 방문한 곳은 그냥 넘어가기
                    }
                    // 방문안했으면
                    queue.add(adj[i]); // 큐에 넣고
                    visited[adj[i]] = true; // 방문처리하기
                }
            }
        }
    }

}