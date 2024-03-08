import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	public static int r,c,result;
	public static char[][] arr;
	
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	// dfs , visited, stack rec
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		for(int i = 0 ; i < r; i++) {
			String tmp = br.readLine();
			arr[i] = tmp.toCharArray(); 

		}
//		
//		for(int i = 0 ; i < r; i++) {
//			for(int j = 0 ; j < c; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		visited = new boolean[26];
		visited[(int)(arr[0][0]-'A')] = true;
		dfs(0,0,1);
		
		System.out.println(result);
	}

	private static void dfs(int x, int y, int depth) {
		result = Math.max(depth, result);
		
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx>=0 && nx<r && ny>=0 && ny<c) {
				if(!visited[(int)(arr[nx][ny]-'A')] ) {
					visited[(int)(arr[nx][ny]-'A')] = true;
					dfs(nx,ny,depth+1);
					visited[(int)(arr[nx][ny]-'A')] =false;
					
				}
			}
			
		}
	}

}
