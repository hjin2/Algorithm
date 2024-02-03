import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] selected;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m];
		visited = new boolean[n+1];
		comb(0);
		
	}

	private static void comb(int cnt) { // cnt번째 들어올 숫자를 고르는 함수
		if(cnt == m) {
			for(int i = 0 ; i < m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= n ; i++) {
			if(visited[i]) continue;
			selected[cnt] = i;
			visited[i] = true;
			comb(cnt+1);
			visited[i] = false;
		}
		
	}
}
