import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static int[][][] board;
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};

    public static int m, n, h, day = 0;
    public static int no = 0;
    public static Queue<int[]> queue;
    public static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];

        visited = new boolean[h][n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    board[i][j][k] = tomato;
                    if (tomato == 1) {
                        queue.add(new int[]{j, k, i, 0});
                        visited[i][j][k] = true;
                    } else if (tomato == 0) {
                        no++;
                    }
                }
            }
        }

        if (no == 0) {
            System.out.println(0);
            System.exit(0);
        }
        bfs();
        if (no != 0) {
            System.out.println(-1);
            System.exit(0);
        }else {
            System.out.println(day);
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {

            int[] positions = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = positions[0] + dx[i];
                int ny = positions[1] + dy[i];
                int nz = positions[2] + dz[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1 || nz < 0 || nz > h - 1) {
                    continue;
                }
                if(board[nz][nx][ny] != 0){
                    continue;
                }
                if(visited[nz][nx][ny]){
                    continue;
                }

                board[nz][nx][ny] = 1;
                visited[nz][nx][ny] = true;
                queue.add(new int[]{nx, ny, nz, positions[3] + 1});
                no--;
                day = Math.max(day, positions[3] + 1);
            }
        }
    }
}