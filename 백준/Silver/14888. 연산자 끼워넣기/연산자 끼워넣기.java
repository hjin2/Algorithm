package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class solv1 {
	static int resultMax = Integer.MIN_VALUE;				// 결과가 최대인 값
	static int resultMin = Integer.MAX_VALUE;				// 결과가 최소인 값
	static int n;								// n개의 수
	static int[] nums; 							// n개의 수를 담을 배열
	static String[] selected;						// 선택된 수
	static String[] operator = { "+", "-", "x", "/" };
	static boolean[] visited;						// 방문유무
	static List<String> list;						// 부호목록들

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] tmps = new int[4];	// 각각 부호의 개수를 담을 임시 배열
		for (int i = 0; i < 4; i++) {
			tmps[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {					// 각각 부호를 담을건데
			for (int j = 0; j < tmps[i]; j++) {			// 부호개수만큼
				list.add(operator[i]);				// 리스트에 넣기
			}
		}

		
		// 5P5
		// { 0, 1, 2, 3 }
		// { - x x + + + }
		selected = new String[n - 1];
		visited = new boolean[n - 1];
		
		p(0);
		
		System.out.println(resultMax);
		System.out.println(resultMin);

	}

	private static void p(int cnt) {
		if (cnt == n-1) { 					// 부호 n-1개를 모두 다 선택한 상태
			calc();						// 뽑힌 부호 순서대로 계산을 진행
			return;
		}
		for (int i = 0; i < n-1; i++) {
			if (visited[i])	continue;
			selected[cnt] = list.get(i);
			visited[i] = true;
			p(cnt+1);
			visited[i] = false;
		}
	}

	private static void calc() {
		int value = nums[0];
		for(int i = 0 ; i < n-1; i++) {
			switch(selected[i]) {
			case "+":
				value = value + nums[i+1]; 
				break;
			case "-":
				value = value - nums[i+1]; 
				break;
			case "x":
				value = value * nums[i+1]; 
				break;
			case "/":
				value = value / nums[i+1]; 
				break;
			
			}
		}
		resultMax = resultMax < value ? value : resultMax;
		resultMin = resultMin > value ? value : resultMin;
		
	}
}
