import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {2, 2, 1, -1, -2, -2, -1, 1};
    public static int[] dy = {1, -1, -2, -2, -1, 1, 2, 2};
    public static Queue<int[]> queue;
    public static boolean[][] visited;
    public static int n;
    public static int targetx, targety;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int nowx = Integer.parseInt(st.nextToken());
            int nowy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetx = Integer.parseInt(st.nextToken());
            targety = Integer.parseInt(st.nextToken());

            queue.add(new int[]{nowx, nowy});
            visited[nowx][nowy] = true;

            dfs();
        }
    }

    public static void dfs() {
        int cnt = 0;
        while (!queue.isEmpty()) {
            int queuesize = queue.size();
            cnt++;
            while (queuesize-- > 0) {
                int[] top = queue.poll(); // 가장 상단 꺼내서

                if (top[0] == targetx && top[1] == targety) {
                    System.out.println(cnt - 1);
                    return;
                }

                for (int i = 0; i < 8; i++) {
                    // 현재에서 갈 수 있는 x,y
                    int nx = top[0] + dx[i];
                    int ny = top[1] + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (visited[nx][ny]) {
                        continue;
                    }
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}