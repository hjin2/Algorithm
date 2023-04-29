import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class blank {
	int x;
	int y;

	public blank(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m;
	static int result = Integer.MIN_VALUE;
	static List<blank> list;
	static int[] selected;
	static boolean[][] visited;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // x
		m = Integer.parseInt(st.nextToken()); // y
		arr = new int[n][m];

		for (int x = 0; x < n; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < m; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		
		dfs(0);
		System.out.println(result);

	}

	private static void dfs(int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}
		for (int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				if(arr[i][j]==0) {
					arr[i][j]=1;
					dfs(cnt+1);
					arr[i][j]=0;
				}
			}

		}

	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[n][m];
		
		for(int x = 0 ; x < n; x++) {
			for(int y = 0 ; y< m; y++) {
				if(arr[x][y]==2) {
					queue.add(x);
					queue.add(y);
					visited[x][y] = true;
				}
			}
		}

		int[][] copy = copy();
		
		while (!queue.isEmpty()) {
			int nowx = queue.poll();
			int nowy = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = nowx + dx[i];
				int ny = nowy + dy[i];
				
				if(nx<0 || nx>=n || ny < 0 || ny>=m ) continue;
				if(visited[nx][ny]) continue;
				if(copy[nx][ny]==1 || copy[nx][ny]==2)continue;
				
				copy[nx][ny] = 2;
				visited[nx][ny] = true;
				queue.add(nx);
				queue.add(ny);
			}
		}
		
		countsafezone(copy);

	}

	private static void countsafezone(int[][] copy) {
		int blankcnt = 0;
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				if(copy[i][j]==0)
					blankcnt++;
			}
		}
		result = result < blankcnt ? blankcnt : result;
	}

	private static int[][] copy() {
		int[][] tmp = new int[n][m];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				tmp[x][y] = arr[x][y];
			}
		}
		return tmp;
	}
}