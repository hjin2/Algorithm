import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int n = Integer.parseInt(br.readLine());
	int[] triNum = new int[45];
	for(int i = 1; i < 45; i++) {
		triNum[i] = i * (i+1) / 2;
	}
	for(int i = 0 ; i < n; i++) {
		int a  =Integer.parseInt(br.readLine());
		int result = eureka(a,triNum);
		System.out.println(result);
	}
}

private static int eureka(int n, int[] triNum) {
	for(int i = 1; i < 45; i++) {
		for(int k = 1; k < 45 ;k++) {
			for(int z = 1; z < 45; z++) {
				int sum = triNum[i] + triNum[k] + triNum[z];
				if(sum==n)
					return 1;
			}
		}
	}
	return 0;
}
}