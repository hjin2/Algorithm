import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int resultMax = Integer.MIN_VALUE;
	static int resultMin = Integer.MAX_VALUE;
	static int n;
	static int[] nums; 
	static String[] selected;
	static String[] operator = { "+", "-", "x", "/" };
	static boolean[] visited;
	static List<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] tmps = new int[4];
		for (int i = 0; i < 4; i++) {
			tmps[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < tmps[i]; j++) {
				list.add(operator[i]);
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
		if (cnt == n-1) {
			calc();
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
