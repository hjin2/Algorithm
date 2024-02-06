import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static int cnt;
	public static int[] nums;
	public static int[] c;
	
	public static void comb(int start, int count) {
		if(count == c.length) {
			int sum = 0;
			for(int i = 0 ; i < c.length; i++) {
				sum += c[i];
			}
			if(sum==m)
				cnt++;
			return;
		}
		for(int i = start; i < n ; i++) {
			c[count] = nums[i];
			comb(i+1, count+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[n];
		for(int i = 0 ; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i < n+1; i++) {
			// nC0 , nC1, nC2
			c = new int[i];
			comb(0,0);
		}
		
		System.out.println(cnt);
	}
}
