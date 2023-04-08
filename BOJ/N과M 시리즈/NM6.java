/*
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
 * N개의 자연수 중에서 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 * 
 * 4 2
9 8 7 1

1 7
1 8
1 9
7 8
7 9
8 9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM6 {
	static int n,m;
	static int[] selected,arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n개의 자연수 중에서
		m = Integer.parseInt(st.nextToken()); // 길이가 m인 수열
		
		selected = new int[m];
		arr = new int[n];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0,0);

	}
	static void comb(int cnt,int before) {
		if(cnt==m) {
			for(int i = 0 ; i < m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0 ; i < n; i++) {
			if(before >  i) continue; 
			if(visited[i]) continue;
			selected[cnt] = arr[i];
			visited[i] = true;
			comb(cnt+1,i);
			visited[i] = false;
		}
		
		
	}
	
	/*
	static void comb(int start, int count) {
		if(count==m) {
			for(int i = 0 ; i < count ;i++) {
				System.out.println(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start ; i < n; i++) {
			selected[count] = arr[start];
			comb(i+1, count+1);
		}
	}
	*/
}
