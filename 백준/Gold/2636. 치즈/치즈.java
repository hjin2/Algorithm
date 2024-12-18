import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cheeseCnt;
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];

		int ans;
		for (ans = 0; isCheese(); ans++) {
			for (boolean[] arr : visited) {
				Arrays.fill(arr, false);
			}
			visited[0][0] = true;
			cheeseCnt = 0;

			DFS(0, 0);
		}

		bw.write(ans + "\n" + cheeseCnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean isCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	public static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int dx = x + rangeX[i];
			int dy = y + rangeY[i];

			
			if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
				continue;
			}

			if (!visited[dx][dy]) {
				visited[dx][dy] = true;
				if (map[dx][dy] == 1) {
					map[dx][dy] = 2;
					cheeseCnt++; // 다음에 지워질 치즈의 개수
				} else {
					DFS(dx, dy);
				}
			}
		}
	}

}