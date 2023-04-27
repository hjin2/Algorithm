import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int start = Integer.parseInt(st.nextToken());
	int end = Integer.parseInt(st.nextToken());
	
	int totalCnt = 1;
	int sum = 0;
	for(int i = 1 ; i  <= 10000 ; i++) {
		int cnt = 1;
		while(cnt <= i) {
			if(start<=totalCnt && totalCnt<=end) {
				sum+=i;
			}
			totalCnt++;
			cnt++;
		}
	}
	System.out.println(sum);
}
}