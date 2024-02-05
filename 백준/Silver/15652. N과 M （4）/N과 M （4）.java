import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] selected;

	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		selected = new int[m + 1];

		
		
		rec_func(1,0);
		
		bw.flush();
		bw.close();

	}

	// Recurrence Function(재귀 함수)
	// 만약 M개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것
	// 만약 M개를 고르지 않음 => k번째부터 m번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
	static void rec_func(int k, int before) throws IOException {
		if (k == m + 1) { // 1~M번째를 전부 다 골랐따!
			// selected[1...M]배열이 새롭게 탐색된 결과
			for (int i = 1; i <= m; i++) {
				//System.out.print(selected[i] + " ");
				bw.write(selected[i] + " ");
			}
			//System.out.println();
			bw.write('\n');
		} else {
			for (int cand = 1; cand <= n; cand++) {
				if(cand<before) continue;
				selected[k] = cand;
				rec_func(k+1, cand);
				
			}
		}
	}
}
