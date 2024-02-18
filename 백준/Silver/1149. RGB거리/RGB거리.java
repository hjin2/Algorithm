import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int removeIdx = -1;
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];
		
		for (int x = 0; x < n; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < 3; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 1부터 n-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
		
		
		for(int i = 1; i < n; i++) {
			arr[i][0] = arr[i][0] + Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1] = arr[i][1] + Math.min(arr[i-1][2], arr[i-1][0]);
			arr[i][2] = arr[i][2] + Math.min(arr[i-1][0], arr[i-1][1]);
		}
		
		int tmp = Math.min(arr[n-1][0], arr[n-1][1]);
		System.out.println(Math.min(tmp, arr[n-1][2]));
		
	}
}
