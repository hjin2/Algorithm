import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static int n, count, house;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static char[][] arr;
	public static boolean[][] visited;

	public static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (!visited[nx][ny]) {
					if (arr[nx][ny] == '1') {
						visited[nx][ny] = true;
						house += 1;
						dfs(nx,ny);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == '1') {
					// 여기서 true를 안해주니까 단지가 하나일 때 확인을 못해줌
					visited[i][j] = true;
					house = 1;
					dfs(i, j);
					count += 1;
					tmp.add(house);
				}
			}
		}
		System.out.println(count);
		
		Collections.sort(tmp);
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i));
		}

		// for(int i = 0 ; i < n ; i++) {
//			for(int j = 0 ; j < n; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
	}
}
