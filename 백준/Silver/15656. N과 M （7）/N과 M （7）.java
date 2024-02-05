import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static List<Integer> arr;
	static int[] pick;
	static boolean[] visited;
	static BufferedWriter bw;

	static void c(int count) throws IOException {
		if (count == m) {
			for (int tmp : pick) {
//				System.out.print(tmp + " ");
				bw.write(tmp + " ");
			}
//			System.out.println();
			bw.write('\n');
			return;
		}

		for (int i = 0; i < n; i++) {
			pick[count] = arr.get(i);
			c(count + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new ArrayList<>();
		pick = new int[m];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);

		c(0);
		bw.flush();
		bw.close();
	}
}
