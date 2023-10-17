import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int islandNum=1;

	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int n;
	public static int[][] arr;
	public static int[][] island;
    public static int[][] edge;

	public static int[][] distance;
    public static boolean[][] visited;
	public static boolean[][] visited2;
	public static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		island = new int[n][n];
		arr = new int[n][n];
        visited = new boolean[n][n];
		visited2 = new boolean[n][n];
		edge = new int[n][n];
		distance = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					arr[i][j] = 1;
				}
			}
		}


		// 1. 각 섬을 다른 숫자로 적기
		// 2. 섬에서 가장자리 찾기
		// 3. 각 가장자리에서 가장 짧은 구역 찾기

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) { // visited를 추가안하면 같은 구역으로 안됨
					bfs(i, j);
				}
			}
		}

		for(int i = 0 ;  i < n; i++){
			for(int j = 0 ; j < n; j++){
				if(edge[i][j]!=0 ){
					bfs2(i,j,edge[i][j],0);
				}
			}
		}

		System.out.println(result);

	}

	// 각 섬을 다른 숫자로 적기
	public static void bfs(int x, int y) {

		island[x][y] = islandNum;
        visited[x][y] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
            int nowY = now[1];

            boolean possible = false;


			for (int i = 0; i < 4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (arr[nx][ny] == 0) {
                    possible = true;
					edge[nowX][nowY]=islandNum; // 바로 edge에 가장자리 표시해주기
                    continue; // possible하고 바로 continue해버리면 밑에꺼 실행 안됨
                }
                if(visited[nx][ny]) continue;

                // 가장자리여야 islandNum, 중간일땐 걍 0이되도록
                // 가장자리인지 확인하는 방법은 사방을 확인했을때 한군데라도 0인 경우가 있는 경우

				island[nx][ny] = islandNum;
                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny});

			}
		}
        islandNum++;
	}

	public static void bfs2(int x, int y,int islandNum, int depth){
		Queue<int[]> queue2 = new LinkedList<>();
		queue2.add(new int[]{x,y,islandNum,depth});
		visited2[x][y] = true;

		while(!queue2.isEmpty()){
			int[] now = queue2.poll();
			int nowX = now[0];
			int nowY = now[1];
			int nowL = now[2];
			int nowD = now[3];

			for(int i = 0 ; i < 4; i++){
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				int nd = nowD + 1;
		

				if(nx<0 || nx>= n || ny<0 || ny>=n){
					continue;
				}
				if(edge[nx][ny]==nowL){
					continue;
				}
				if(visited2[nx][ny]){
					continue;
				}

				if (edge[nx][ny] == 0){
					visited2[nx][ny] = true;
					distance[nx][ny]=nd;
					queue2.add(new int[]{nx,ny,nowL,nd});
				}
				if(edge[nx][ny]!=0 && edge[nx][ny]!=nowL){
					result = result > nowD ? nowD: result;
					queue2.clear();
					visited2= new boolean[n][n];
					break;
				}
			}
		}

	}


}