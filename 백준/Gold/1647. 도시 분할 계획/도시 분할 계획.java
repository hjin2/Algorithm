import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	public static int[][] weight;
	public static int[] parent;
	public static int v,e,sum;
	public static int big = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		int[][] arr = new int[e][3];
		weight = new int[e][3];
		parent = new int[v+1];

		for(int i = 0 ; i <= v ; i++ ){
			parent[i] = i;
		}

		for(int i = 0 ; i < e ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[i][0] = a;
			arr[i][1] = b;
			arr[i][2] = w;
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});

		// for(int i = 0 ; i < e ; i++) {
		// 	System.out.println("i: " + i);
		// 	for (int j = 0; j < 3; j++) {
		// 		System.out.print(arr[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		for(int i = 0 ; i < e ; i++){
			if(find(arr[i][0]) != find(arr[i][1])){
				union(arr[i][0], arr[i][1]);
				sum += arr[i][2];
				big = big < arr[i][2] ? arr[i][2] :big;
			}
		}

		// System.out.println(sum);
		// System.out.println(big + " d");
		System.out.println(sum- big);

	}
	public static int find(int n){
		if(parent[n] == n){
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
}
