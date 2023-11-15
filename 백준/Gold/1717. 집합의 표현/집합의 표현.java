import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n+1];

		for(int i = 0 ; i < n+1 ; i++){
			parent[i] = i;
		}

		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(x==0){
				union(a,b);
			}else{
				check(a,b);
			}

		}
	}

	public static int find(int n){
		if(n==parent[n]){
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	public static void union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);

		if(rootA < rootB){
			parent[rootB] = rootA;
		}else{
			parent[rootA] = rootB;
		}
	}

	public static void check(int a, int b){
		if(find(a)==find(b)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
