/*
 N���� �ڿ��� �߿��� M���� �� ����
���� ���� ���� �� ��� �ȴ�.
�� ������ �񳻸������̾�� �Ѵ�.
���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.

4 2
9 7 9 1


1 1
1 7
1 9
7 7
7 9
9 9
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM12 {
	static int n, m;
	static int[] selected, arr;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		selected = new int[m];
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0,0);
		
		bw.flush();
		bw.close();
	}

	static void comb(int cnt,int start) throws IOException {
		if(cnt==m) {
			for(int i = 0 ; i < m; i++) {
				//System.out.print(selected[i]+" ");
				bw.write(selected[i] + " ");
			}
			//System.out.println();
			bw.write('\n');
			return;
		}
		int before = -1;
		for(int i= start ; i < n; i++) {
			if(before == arr[i]) continue;
			selected[cnt] = arr[i];
			before = arr[i];
			comb(cnt+1,i);
		}
	}
}
