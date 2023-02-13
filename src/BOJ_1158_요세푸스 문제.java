package live_0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> l = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			l.add(i, i + 1);
		}
		System.out.print("<");
		while(l.size()>0) {
			for(int i = 0; i < k-1; i++) {
				int tmp = l.getFirst();
				l.add(tmp);
				l.removeFirst();
			}
			if(l.size()==1)
				System.out.print(l.getFirst());
			else
				System.out.print(l.getFirst() + ", ");
			l.removeFirst();
		}
		System.out.println(">");

	}
}
