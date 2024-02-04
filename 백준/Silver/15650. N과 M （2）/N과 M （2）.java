import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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
