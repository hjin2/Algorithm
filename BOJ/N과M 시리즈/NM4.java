/*
1���� N���� �ڿ��� �߿��� M���� �� ����
���� ���� ���� �� ��� �ȴ�.
�� ������ �񳻸������̾�� �Ѵ�.
���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.

4 2

1 1
1 2
1 3
1 4
2 2
2 3
2 4
3 3
3 4
4 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM4 {
	static int n, m;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m];
		
		comb(0, 1);
	}

	static void comb(int cnt, int before) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int cand = 1; cand <= n; cand++) {
			if(before>cand)continue;
			selected[cnt] = cand;
			comb(cnt+1, cand);
		}
	}
	
	
	/*
	 * 	static void comb(int cnt, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i <= n; i++) {
			selected[cnt] = i;
			comb(cnt+1, i);
		}
	}
	 */
}
