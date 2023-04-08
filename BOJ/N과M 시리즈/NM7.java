/*
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.

4 2
9 8 7 1

1 1
1 7
1 8
1 9
7 1
7 7
7 8
7 9
8 1
8 7
8 8
8 9
9 1
9 7
9 8
9 9
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM7 {
	static int n,m;
	static int[] arr,selected;
	static boolean[] visited;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		for(int i = 0; i < n ;i++) {
			selected[cnt] = arr[i];
			comb(cnt+1);
			
		}
	}
}
