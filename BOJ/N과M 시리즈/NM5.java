import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  N개의 자연수는 모두 다른 수이다.
	N개의 자연수 중에서 M개를 고른 수열
	
	4 2
9 8 7 1

1 7
1 8
1 9
7 1
7 8
7 9
8 1
8 7
8 9
9 1
9 7
9 8
 */
public class NM5 {
	static int[] arr;
	static int[] selected;
	static boolean[] visited;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		selected = new int[m];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0);

	}

	static void comb(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int cand = 0; cand < n; cand++) {
			if(visited[cand]) continue;
			selected[cnt] = arr[cand];
			visited[cand] = true;
			comb(cnt + 1);
			visited[cand] =false;
		}
	}
}
