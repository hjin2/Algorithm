import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BOJ_2798_블랙잭 {
	public static int compare(int m, int sum, int result) { // m과 세수의 합 sum, 결과를 담을 result를 받아온다. 초기에 result는 int의 가장 작은수로해서 무조건 처음 더한 세수의 합이 result보다 크다.
		if(sum <= m) { // 더한 세 수의 합이 m보다 같거나 작으면
			if(sum > result) { // 그리고 현재 더한 세 수의 값이, 이전의 결과들 보다 크면 (m이랑 더 근접할수록 좋으니까) 
				result = sum;  // 최종결과를 담는 result 변수에 sum을 대입한다.
				return result; // result를 반환한다.
			}
		}
		return result; // sum이 m보다 크면 소용이 없으니까, 그냥 이 전에 더한 것들 중 가장 답이 되는 result를 반환한다.
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	// n과 m을 한줄에 받아옴
		
		int n = Integer.parseInt(st.nextToken());	// 카드의 개수 n
		int m = Integer.parseInt(st.nextToken());	// 카드에 쓰여진 총 합 m
		
		int[] numList = new int[n];	// 숫자 n개를 담아서 저장할 배열
		
		st = new StringTokenizer(br.readLine()); // 공백을 기준으로 숫자 n개를 받아옴
		for(int i = 0 ; i < n ; i++) {	// n개를 돌면서
			numList[i] = Integer.parseInt(st.nextToken()); // 배열에 저장
//			System.out.println(numList[i]);
		}
		int result = Integer.MIN_VALUE;	// 최종적인 결과가 들어갈 변수, m과 같거나 가장 근접한 수
		int sum = 0;	// 숫자 세개를 더한 값
		for(int i = 0; i < n-2 ; i++) {
			for(int j = i+1; j < n-1 ; j++) {
				for(int k = j+1; k < n; k++) {
					sum = numList[i] + numList[j] + numList[k]; // 123 124 125 134 .. 이런식으로 더함
					result = compare(m, sum, result);	// 더한값이 m보다 같거나 작은지 그리고 그 전의 합들보다 더 큰지 비교하는 함수, 결과값을 result에 저장
				}
			}
		}
		System.out.println(result);
		
		
	}
}
