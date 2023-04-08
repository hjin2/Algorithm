/*
 * N개의 자연수 중에서 M개를 고른 수열
 * 
 * 4 2
9 7 9 1
 * 
1 7
1 9
7 1
7 9
9 1
9 7
9 9
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NM9 {
	static int n, m;
	static int[] arr, selected;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // n개의 자연수 중에서
		m = Integer.parseInt(st.nextToken()); // 길이가 m인 수열

		arr = new int[n];
		selected = new int[m];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		p(0);
		
	}

	static void p(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(selected[i] + " ");
				
			}
			System.out.println();
			return;
		}
		int before = -1;
		for (int i = 0; i < n; i++) {
			if(before==arr[i]) continue;
			if (visited[i])continue;
			selected[cnt] = arr[i];
			visited[i] = true;
			before = arr[i];
			p(cnt + 1);
			visited[i] = false;
		}
	}
}
