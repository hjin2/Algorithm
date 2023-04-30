import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int x;
	int y;
	int dist;

	public Node(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		if(dist==o.dist) {
			if (x == o.x)
				return y - o.y;
			else
				return x - o.x;	
		}
		return dist - o.dist;
	}

}

public class Main {
	static int sharkSize = 2;
	static int n;
	static int time = 0;
	static int eat = 0;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (arr[x][y] == 9)
					bfs(x, y);
			}
		}
		System.out.println(time);
	}

	private static void bfs(int startX, int startY) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][n];
		queue.add(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		arr[startX][startY] = 0;

		while (!queue.isEmpty()) {
			if (callMom()) {
				return;
			}

			Node node = queue.poll();
			int nowX = node.x;
			int nowY = node.y;
			int nowD = node.dist;
			//System.out.println("nowX: " +nowX + "  nowY: " + nowY + "  nowD: " + nowD);

			if (arr[nowX][nowY] < sharkSize && arr[nowX][nowY] > 0) {
				arr[nowX][nowY] = 0;
				eat += 1;
				
				//System.out.println("eat : " + eat);
				//System.out.println("nowD : " + nowD);
				
				time+= (nowD-time);
				//System.out.println("time : " + time);
				
				if (eat == sharkSize) {
					sharkSize += 1;
					eat = 0;
					//System.out.println(sharkSize + "크기다!!!!!!!!!!!!!!!!!!!!!!!!");

				}
				
				queue.clear();
				queue.add(new Node(nowX, nowY, 0));
				visited = new boolean[n][n];
				visited[nowX][nowY] = true;
			}
			
	

			for (int i = 0; i < 4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				int nd = nowD + 1;

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (arr[nx][ny] > sharkSize) continue;
				if (visited[nx][ny]) continue;

				queue.add(new Node(nx, ny, nd));
				visited[nx][ny] = true;
			}

		}

	}

	private static boolean callMom() {
		boolean callMom = true;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (arr[x][y] < sharkSize && arr[x][y] != 0) { // 돌면서 하나라도 0이 아니면서 상어 사이즈보다 작은게 있으면 먹을 수 있다
					callMom = false; // 엄마를 부르지 마!
					return callMom;
				}
			}
		}
		return callMom;
	}

}