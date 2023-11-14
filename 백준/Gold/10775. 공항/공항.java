import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] parent;
	public static int cnt;
	public static boolean possible = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int gate = Integer.parseInt(br.readLine());
		int airplane = Integer.parseInt(br.readLine());
		parent = new int[gate + 1];

		for (int i = 0; i <= gate; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= airplane; i++) {
			int fly = Integer.parseInt(br.readLine());

			if (union(fly)) {
				cnt++;
			} else {
				break;
			}

		}
		System.out.println(cnt);

	}

	public static int find(int n) {
		if (parent[n] == n) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	public static boolean union(int n) {
		int rootA = find(n);
		int rootB = rootA - 1;

		if (rootA == 0) {
			return false;
		}

		parent[rootA] = rootB;

		return true;
	}
}

