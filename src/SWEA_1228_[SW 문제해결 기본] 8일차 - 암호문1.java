package live_0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_0213 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			LinkedList<Integer> l = new LinkedList<Integer>();

			StringTokenizer st = new StringTokenizer(br.readLine()); // 원본 암호문 입력
			while (st.hasMoreTokens()) { // 원본 암호문 추가
				l.add(Integer.parseInt(st.nextToken()));
			}

			int m = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine()); // 명령어

			int lcnt = 0;
			while (st.hasMoreElements()) {
				String str = st.nextToken();
				int start = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int loop = cnt;
				while (loop > 0) {
					for (int i = start; i < start + cnt; i++) {
						int tmp = Integer.parseInt(st.nextToken());
						l.add(i, tmp);
						loop -= 1;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(l.get(i) + " ");
			}
			System.out.println();
		}
	}
}
