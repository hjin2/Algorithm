
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;	// 1부터 n까지 자연수
	public static int m;	// 중복 없이 m개 고르기
	public static int[] numlist;	// m개를 고를 때 수를 나열할 int형 배열
	public static boolean[] isVisited;	// 1부터 n까지 수에 방문했는지 안했는지를 체크할 boolean형 배열, 1~n까지 인덱스를 쓰기 위해서 n+1크기로 배열을 만든다.
	
	public static void nm1(int cnt) {
		if(cnt == m) {	// m개를 모두 골랐으면 출력하기
			for(int i = 0 ; i < numlist.length; i++) {
				System.out.print(numlist[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= n; i++){
			if(isVisited[i]) continue; // i번에 방문했으면 아래 실행안하고 i++
			numlist[cnt] = i;	 // 인덱스[cnt]번째에 i 대입, m개 고르는데 cnt번째 수가 i
			isVisited[i] = true; // i를 대입했다. 즉 방문했기때문에 true로 변경
			nm1(cnt+1);			 // 다음칸에 들어갈 숫자 찾기
			isVisited[i] = false; // 갔다온 칸 false로 변경하여 다음번에 쓸 수 있도록 함
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			n = Integer.parseInt(st.nextToken()); // 1부터 n까지 자연수
			m = Integer.parseInt(st.nextToken()); // m개 고르기
		}
		numlist = new int[m];			// 길이가 m, m개의 수
		isVisited = new boolean[n+1];	// 1부터 n까지 수에 방문했는지 안했는지를 체크할 boolean형 배열, 1~n까지 인덱스를 쓰기 위해서 n+1크기로 배열을 만든다.
		
		// 1부터 n까지 자연수 중에서 중복없이 m개를 고른 수열
		nm1(0);	// 0번째값
	}
}
