/*
 * N���� �ڿ��� �߿��� M���� �� ����
�� ������ �񳻸������̾�� �Ѵ�.
���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.

4 2
9 7 9 1

1 7
1 9
7 9
9 9
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM10 {
	static int n, m;
	static int[] arr, selected;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // n���� �ڿ��� �߿���
		m = Integer.parseInt(st.nextToken()); // ���̰� m�� ����

		arr = new int[n];
		selected = new int[m];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		p(0,0);
	}
	static void p(int cnt, int start) {
		if(cnt==m) {
			for(int i = 0 ; i < m; i++) {
				System.out.print(selected[i]+ " ");
			}
			System.out.println();
			return;
		}
		int before = -1;
		for(int i = start ;i < n; i++) {
			if(before == arr[i]) continue;
			if(visited[i])continue;
			selected[cnt] = arr[i];
			visited[i] = true;
			before = arr[i];
			p(cnt+1, i+1);
			visited[i] = false;
		}
	}
}
