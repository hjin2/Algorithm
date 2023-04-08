import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] selected;
	static List<int[]> chick;
	static List<int[]> homes;
	static boolean[] visited;
	static List<Integer> candlist;
	public static void main(String[] args) throws IOException {
		// 1. 치킨집 좌표를 리스트에 넣기
		// 2. 그냥 집인 좌표 리스트에 넣기
		// 3. 치킨집 좌표를 m개 고르기
		// 4. 고른좌표 기존의 집의 좌표의 차이 구하기
		// 4-1. 여기서 좀 헷갈리는데 치킨집이 m개랑 집의좌표를 한번씩 다 구해서 가장 작은 값을 치킨거리로 설정함
		// 치킨거리의 총 합 구하기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		chick = new ArrayList<>();
		homes = new ArrayList<>();
		candlist = new ArrayList<>();
		
		int[][] arr = new int[n][n];
		for (int x = 0; x < n; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < n; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
				if (arr[x][y] == 1)
					homes.add(new int[] { x, y });
				else if (arr[x][y] == 2)
					chick.add(new int[] { x, y });
			}
		}

		selected = new int[m];
		visited = new boolean[chick.size()];
		c(0, 0);
		System.out.println(Collections.min(candlist));

	}

	static void c(int cnt, int start) {
		
		if (cnt == m) {
			int minresult = 0;
			for (int h = 0; h < homes.size(); h++) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < m; i++) {
					int cand = lengCalc(selected[i], h);
					//System.out.println("cand : " + cand);
					min = Math.min(min, cand);
				}
				minresult += min;
				//System.out.println();
			}
			candlist.add(minresult);
			return;
		}
		for (int i = start; i < chick.size(); i++) {
			selected[cnt] = i;
			c(cnt + 1, i + 1);
		}
	}

	private static int lengCalc(int chkidx, int hidx) {
		// 인덱스가 idx번째인 치킨집과, 가정집들 사이의 거리 차들 중 가장 작은 것을 고르는 함수
		// 인덱스가 idx번째인 치킨집의 좌표
		int tmp = 0;
		
		int cx = chick.get(chkidx)[0];
		int cy = chick.get(chkidx)[1];

		int hx = homes.get(hidx)[0];
		int hy = homes.get(hidx)[1];
		//System.out.println(cx + "\t" + cy + "\t" + hx + "\t" + hy);
		tmp = Math.abs(cx-hx) + Math.abs(cy-hy);

		
		return tmp;
		
		

	}
}