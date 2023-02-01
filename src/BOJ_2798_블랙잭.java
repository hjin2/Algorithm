import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BOJ_2798_���� {
	public static int compare(int m, int sum, int result) { // m�� ������ �� sum, ����� ���� result�� �޾ƿ´�. �ʱ⿡ result�� int�� ���� ���������ؼ� ������ ó�� ���� ������ ���� result���� ũ��.
		if(sum <= m) { // ���� �� ���� ���� m���� ���ų� ������
			if(sum > result) { // �׸��� ���� ���� �� ���� ����, ������ ����� ���� ũ�� (m�̶� �� �����Ҽ��� �����ϱ�) 
				result = sum;  // ��������� ��� result ������ sum�� �����Ѵ�.
				return result; // result�� ��ȯ�Ѵ�.
			}
		}
		return result; // sum�� m���� ũ�� �ҿ��� �����ϱ�, �׳� �� ���� ���� �͵� �� ���� ���� �Ǵ� result�� ��ȯ�Ѵ�.
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	// n�� m�� ���ٿ� �޾ƿ�
		
		int n = Integer.parseInt(st.nextToken());	// ī���� ���� n
		int m = Integer.parseInt(st.nextToken());	// ī�忡 ������ �� �� m
		
		int[] numList = new int[n];	// ���� n���� ��Ƽ� ������ �迭
		
		st = new StringTokenizer(br.readLine()); // ������ �������� ���� n���� �޾ƿ�
		for(int i = 0 ; i < n ; i++) {	// n���� ���鼭
			numList[i] = Integer.parseInt(st.nextToken()); // �迭�� ����
//			System.out.println(numList[i]);
		}
		int result = Integer.MIN_VALUE;	// �������� ����� �� ����, m�� ���ų� ���� ������ ��
		int sum = 0;	// ���� ������ ���� ��
		for(int i = 0; i < n-2 ; i++) {
			for(int j = i+1; j < n-1 ; j++) {
				for(int k = j+1; k < n; k++) {
					sum = numList[i] + numList[j] + numList[k]; // 123 124 125 134 .. �̷������� ����
					result = compare(m, sum, result);	// ���Ѱ��� m���� ���ų� ������ �׸��� �� ���� �յ麸�� �� ū�� ���ϴ� �Լ�, ������� result�� ����
				}
			}
		}
		System.out.println(result);
		
		
	}
}
