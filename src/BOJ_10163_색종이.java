import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine()); 			// n장의 색종이를 입력받는다.
		int[][] all = new int[1001][1001];		 			// 색종이가 놓이는 평면은 가로 최대 1001칸, 세로 최대 1001칸이니까 
		
		
		// 1. 색종이 넓이에 넘버링 하기
		for (int i = 0; i < n; i++) {						// N장의 색종이의 왼쪽칸좌표, 가로, 세로를 입력받는것을 n번 반복
			String numList = br.readLine();					// 0 0 10 10 띄어쓰기를 기준으로 입력받는다.
			StringTokenizer st = new StringTokenizer(numList); // 토큰으로 나누어서
			while (st.hasMoreTokens()) {					// 토큰이 있을때까지
				int startx = Integer.parseInt(st.nextToken());	// 첫번째 토큰은 왼쪽칸의 x좌표
				int starty = Integer.parseInt(st.nextToken());	// 두번째 토큰은 왼쪽칸의 y좌표 
				int garo = Integer.parseInt(st.nextToken());	// 세번째 토큰은 가로의 길이
				int sero = Integer.parseInt(st.nextToken());	// 네번째 토큰은 세로의 길이
				for (int j = startx; j < startx + garo; j++) {	// 왼쪽아래칸의 x좌표 startx에서 startx에 가로길이 더한 값까지 반복문 돌림
					for (int k = starty; k < starty + sero; k++) {	// 왼쪽아래칸의 y좌표 starty에서 starty에 세로길이 더한 것까지 반복문 돌림
						all[j][k] = (i + 1);	// all[startx][starty], all[startx][starty+1], all[startx][starty+2] .. all[startx+garo-1][starty+sero-1]
					} // 색종이의 넓이에 해당하는 칸에 (i+1)의 값을 대입한다. i는 0부터 n-1까지니까 +1해서 1부터 n까지 값을 넣는다.
					// 넓이의 칸에 1을 넣어놓고 다음 색종이가 들어왔을때는 해당 넓이에 2를 넣는다. 또 다음 색종이는 3을 넣고..의 반복
				}
			}

		}
		
		// 2. 색종이칸을 전체 돌면서, 각각의 넓이를 구하기
		int last = 1;
		int sum = 0;
		while (last <= n) { // n장의 색종이가 있을때, n개의 넓이를 구하기 위해서 n번 반복문을 돌린다.
			for (int r = 0; r < 1001; r++) {	// row 가로행
				for (int c = 0; c < 1001; c++) { // column 세로행
					if(all[r][c] == last) {		// [0][0] == 1, 즉 00에서 100100 까지 한칸씩 이동하면서 그 값이 1일 때 
						sum += all[r][c] / last; // 값을 sum에 저장, 여기서 나누기 last를 해주는 이유는, 1을 찾고 다음에 2를 찾을 때 칸에 2가 들어있는 것을 찾고 해당 수를 sum에 저장하면
												 // 2의 개수가 아니라 2의 누적합이 더해진다. 2가 8개가 있는 경우 8이 아닌, 16이 저장된다. 그래서 last로 나눠서 해당 수의 개수를 구하는 것이다. 총합이 아닌 
					}
				}
			}
			System.out.println(sum); // 첫번째장의 색종이의 합을 출력
			sum = 0;				// 합을 초기화
			last += 1;				// 2번째장 색종이 구하기, 3번째장 색종이 구하기, 등등..
			
		}
	}
}
