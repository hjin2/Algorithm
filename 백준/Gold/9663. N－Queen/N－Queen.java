import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, result = 0;
	static int[] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		rec_func(0);
		System.out.println(result);
	}

	private static void rec_func(int row) {
		if (row == n) {
			result++;
			return;
		} else {
			for (int c = 0; c < n; c++) {
				boolean possible = true;;
				// valid check (row, c)
				for (int b = 0; b < row; b++) {
					// (b, arr[b])
					if (attackable(row, c, b, arr[b])) {
						possible = false;
						break;
					}
				}
				if (possible) {
					arr[row] = c;
					rec_func(row + 1);
					arr[row] = -1;
				}
			}
		}
	}

	static boolean attackable(int r1, int c1, int r2, int c2) {
		if (c1 == c2)
			return true;
		if (r1 - c1 == r2 - c2)
			return true;
		if (r1 + c1 == r2 + c2)
			return true;
		return false;
	}
}