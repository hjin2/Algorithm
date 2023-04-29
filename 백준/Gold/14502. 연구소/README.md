# [Gold IV] 연구소 - 14502 

[문제 링크](https://www.acmicpc.net/problem/14502) 

### 성능 요약

메모리: 303456 KB, 시간: 992 ms

### 분류

너비 우선 탐색, 브루트포스 알고리즘, 그래프 이론, 그래프 탐색, 구현

### 문제 설명

<p>인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.</p>

<p>연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. </p>

<p>일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.</p>

<p>예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.</p>

<pre>2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0</pre>

<p>이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.</p>

<p>2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.</p>

<pre>2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0</pre>

<p>바이러스가 퍼진 뒤의 모습은 아래와 같아진다.</p>

<pre>2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0</pre>

<p>벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.</p>

<p>연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)</p>

<p>둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.</p>

<p>빈 칸의 개수는 3개 이상이다.</p>

### 출력 

 <p>첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.</p>

### 풀이
1. 빈칸인 곳 중에 3개 뽑아서 벽세우고
2. 바이러스 퍼지게 하기
3. 최종적으로 퍼질 수 없는(즉 0인 곳) 계산

<br><br>
나의 틀린 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n, m;
	static int result = Integer.MAX_VALUE;
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
		list = new ArrayList<>();

		for (int x = 0; x < n; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < m; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
				if (arr[x][y] == 0) {
					list.add(new blank(x, y));
				}
			}
		}

		selected = new int[3];
		comb(0, 0);
		System.out.println(result);

	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			int[][] copy = copy();
			for (int i = 0; i < 3; i++) {
				int x = list.get(selected[i]).x;
				int y = list.get(selected[i]).y;
				copy[x][y] = 1;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 2)
						bfs(i, j, copy);
				}
			}
			return;
		}
		for (int i = start; i < list.size(); i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	private static void bfs(int startx, int starty, int[][] copy) {
		visited = new boolean[n][m];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startx);
		queue.add(starty);
		visited[startx][starty] = true;

		while (!queue.isEmpty()) {
			int nowx = queue.poll();
			int nowy = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = nowx + dx[i];
				int ny = nowy + dy[i];
				
				if(nx<0 || nx>=n || ny < 0 || ny>=m ) continue;
				if(visited[nx][ny]) continue;
				
				copy[nx][ny] = 1;
				queue.add(nx);
				queue.add(ny);
			}
		}
		
		int blankcnt = 0;
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				if(copy[i][j]==0)
					blankcnt++;
			}
		}
		
		result = result > blankcnt ? blankcnt : result;

	}

	private static int[][] copy() {
		int[][] copy = new int[n][m];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				copy[x][y] = arr[x][y];
			}
		}
		return copy;
	}
}
```
처음에 조합으로 세군데 뽑아서 계산하려 했으나 아님
<br>
bfs와 dfs!
