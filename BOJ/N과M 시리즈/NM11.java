/*
 N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.

4 2
9 7 9 1

1 1
1 7
1 9
7 1
7 7
7 9
9 1
9 7
9 9
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM11 {
	static int n, m;
	static int[] selected, arr;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		selected = new int[m];
		arr = new int[n];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0);
		
		bw.flush();
		bw.close();
	}

	static void comb(int cnt) throws IOException {
		if(cnt==m) {
			for(int i = 0 ; i < m; i++) {
				//System.out.print(selected[i]+" ");
				bw.write(selected[i] + " ");
			}
			//System.out.println();
			bw.write('\n');
			return;
		}
		for(int i= 0 ; i < n; i++) {
			if(i!=0 && arr[i]==arr[i-1]) continue;
			selected[cnt] = arr[i];
			comb(cnt+1);
		}
	}
}
