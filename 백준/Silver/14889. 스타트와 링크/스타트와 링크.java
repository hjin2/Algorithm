import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int result = Integer.MAX_VALUE;
	static int[] selected;
	static boolean[][] visited;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];

		StringTokenizer st = null;
		for (int x = 1; x < n + 1; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 1; y < n + 1; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		selected = new int[(n / 2) + 1];
		visited = new boolean[n+1][n+ 1];
		comb(1, 1);
		System.out.println(result);

	}

	private static void comb(int cnt, int start) {
		if (cnt == (n / 2) + 1) {
			// 1,2,3,4 팀 짜기
//			for (int i = 0; i < selected.length; i++) {
//				System.out.print(selected[i] + "  ");
//			}
//			System.out.println();
			int group1 = exp(selected);
			int group2 = findelse(selected);
			//System.out.println(group2);
			//System.out.println(group1);
			result = result > Math.abs(group2-group1) ? Math.abs(group2-group1) : result;
			return;
		}

		for (int i = start; i <= n; i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	private static int findelse(int[] selected) {
		visited = new boolean[n+1][n+1];
		for (int s = 0; s < selected.length; s++) {
			for (int i = 0; i < visited.length; i++) {
				if (i == selected[s]) {
					for (int j = 0; j < visited.length; j++) {
						visited[i][j] = true;
						visited[j][i] = true;
					}
				}
			}
		}
		int sum = 0;
		for(int i = 0 ; i < visited.length; i++) {
			for(int j = 0 ; j < visited.length; j++) {
				if(!visited[i][j])
					sum += arr[i][j];
			}
		}
		return sum;
	}

	private static int exp(int[] selected) {
		int sum = 0;
		for (int i = 1; i < selected.length; i++) {
			for (int j = 1; j < selected.length; j++) {
				sum += arr[selected[i]][selected[j]];
			}
		}
		return sum;
	}
}