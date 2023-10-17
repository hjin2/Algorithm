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
		// 각 가장자리에서 가장 짧은 구역 찾기
        // System.out.println("왜");
        // for(int i = 0 ; i < n; i++){
        //     for(int j = 0 ; j < n; j++){
        //         // check(i,j);
        //         System.out.print(edge[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
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
				// System.out.println("nowX " + nowX + "  nowY : " + nowY);

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (arr[nx][ny] == 0) {
					// System.out.println("나에게 0이 있어요 arr[nx][ny]==0 " + nx + "  " + ny);
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
		// System.out.println("==========================================================BFS2=============");
		// System.out.println("===============x : " + x + " y : " + y + " islandNum : " + islandNum + " depth : " + depth + "===========");
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
				// System.out.println("다음x: " + nx +  "   다음y: " + ny + "  다음d : " + nd);

				if(nx<0 || nx>= n || ny<0 || ny>=n){
					// System.out.println("배열 밖이라서 넘어가요");
					continue;
				}
				if(edge[nx][ny]==nowL){
					// System.out.println("같은 섬 가장자리라서 넘어가요");
					continue;
				}
				if(visited2[nx][ny]){
					// System.out.println("방문한 곳이라서 넘어가요");
					continue;
				}
				// if(arr[nx][ny]==nowL){
				// 	System.out.println("가려는곳이 내 섬 내부라서 넘어갔어용");
				// 	continue;
				// }
				if (edge[nx][ny] == 0){
					// System.out.println("빈칸이다! 방문처리하고 큐에 넣었어요");
					visited2[nx][ny] = true;
					distance[nx][ny]=nd;
					queue2.add(new int[]{nx,ny,nowL,nd});
				}
				if(edge[nx][ny]!=0 && edge[nx][ny]!=nowL){
					// System.out.println("이때의 x : " + nowX + "이때의 y : " + nowY + "depth : " + nowD);
					result = result > nowD ? nowD: result;
					// System.out.println("다음x: 0   다음y: 7  다음d : 5 => 이 때 멈추어야한다...");
					// System.out.println("다른 섬을 만났을 때의 depth는???? : " + nd);
					queue2.clear();
					visited2= new boolean[n][n];
					break;
				}
			}
		}

	}


}
