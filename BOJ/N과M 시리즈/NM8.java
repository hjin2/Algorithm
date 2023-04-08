
/*
 N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

4 2
9 8 7 1

1 1
1 7
1 8
1 9
7 7
7 8
7 9
8 8
8 9
9 9
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM8 {
	static int n, m;
	static int[] selected, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // n개의 자연수 중에서
		m = Integer.parseInt(st.nextToken()); // 길이가 m인 수열

		arr = new int[n];
		selected = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		comb(0, 0);
	}

	static void comb(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int cand = start; cand < n; cand++) {

			selected[cnt] = arr[cand];
			comb(cnt + 1, cand);
		}
	}
}
