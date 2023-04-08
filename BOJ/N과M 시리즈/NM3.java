/*
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 4 2
 * 
1 1
1 2
1 3
1 4
2 1
2 2
2 3
2 4
3 1
3 2
3 3
3 4
4 1
4 2
4 3
4 4
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NM3 {
	static int n,m;
	static int[] selected;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m];
		comb(0);
		
		bw.flush();
		bw.close();

	}
	
	static void comb(int cnt) throws IOException {
		if(cnt==m) {
			for(int i = 0 ; i < m; i++) {
				//System.out.print(selected[i] + " ");
				bw.write(selected[i] + " ");
			}
			//System.out.println();
			bw.write('\n');
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			selected[cnt] = i;
			comb(cnt+1);
		}
	}
}
