/*
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 * 4 2
 * 
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM2 {
	static int n, m;
	static int[] selected;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		selected = new int[m];
		visited = new boolean[n + 1];

		comb(0, 1);

	}

	static void comb(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= n; i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
}
