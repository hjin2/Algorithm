import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int count;
	static int[] solutions;
	static final int N = 10;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		solutions = new int[N];
		for(int i = 0; i < N; i++) {
			solutions[i] = Integer.valueOf(st.nextToken());
		}
		
		backTracking(new int[N], 0, 0);
		System.out.println(count);
	}
	
	static void backTracking(int[] mySolutions, int solutionCount, int index) {
		if(N - index + solutionCount < 5) {
			return;
		}
		
		if(index == N) {
			if(solutionCount >= 5) {
				count++;
			}
		}
		else {
			int notAnswer = 0;
			if(index >= 2) {	
				if(mySolutions[index - 1] == mySolutions[index - 2]) {
					notAnswer = mySolutions[index - 1];
				}
			}
		
			for(int i = 1; i <= 5; i++) {
				if(i == notAnswer) {	// 3연속 정답은 패스
					continue;
				}
				

				mySolutions[index] = i;
				if(solutions[index] == i) {
					backTracking(mySolutions, solutionCount + 1, index + 1);
				}
				else {
					backTracking(mySolutions, solutionCount, index + 1);
				}
				mySolutions[index] = 0;
			}
		}
	}
}