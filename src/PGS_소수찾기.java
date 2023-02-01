import java.util.HashSet;
import java.util.Iterator;


public class PGS_�Ҽ�ã�� {
	HashSet<Integer> numberSet = new HashSet<>();
	
	public boolean isPrime(int num) {
		// 1. 0�� 1�� �Ҽ��� �ƴϴ�.
		if(num==0 || num==1) {
			return false;
		}
		// 2. �����佺�׳׽��� ü�� limit�� ����Ѵ�. limit�� 71�� ���� �������� 8������ ����ϸ� �ȴٴ� �� (��Ʈ���� ��������)
		// ������� �Դٴ� ���� 0�� 1�� �ƴ� ���ڰ� ���Դٴ°Ŵ�.
		int lim  = (int)Math.sqrt(num); // ������ ������� Ȯ���Ұųĸ� ��Ʈ�� ���� �������� Ȯ���Ұ��̴�.
		
		// 3. �����佺�׳׽��� ü�� ���� limit������ ��� ���θ� Ȯ���Ѵ�.
		for(int i = 2; i <= lim ; i++) {
			if(num % i == 0 )
				return false;
		}
		return true;
	}
	public void recursive(String com, String others) { // com : ���±��� ���յ� ���ڸ� �ǹ� , others : ���±��� ���� ���� ����
		// 1. ���� ������ set�� �߰��Ѵ�. 
		// combination�� ��������� ����Լ� �ȿ� ���������ٵ� ���� ����Լ� �ȿ��� ������� combination�� ���� set�� �� �� �߰��Ѵ�.
		if(!com.equals(""))
			numberSet.add(Integer.valueOf(com));
		
		
		// 2. ���� ���� �� �Ѱ��� �� �� ���ο� ������ �����.
		for(int i = 0 ; i < others.length() ; i++) {
			recursive(com + others.charAt(i), others.substring(0,i) + others.substring(i+1));
		}
		
	}
	public int solution(String numbers) {
		int count = 0;
		// 1. ��� ������ ���ڸ� �����.
		recursive("",numbers); // ""���±��� ������ ���ڴ� ���� ���°Ŵ�. �����ִ� ���ڴ� �츮�� ���޹��� ���� ��ü numbers
		
		System.out.println(numberSet);
		
		// 2. �Ҽ��� ������ ����.
		Iterator<Integer> it = numberSet.iterator();
		while(it.hasNext()) {
			int number = it.next();
			if(isPrime(number)) {
				count++;
			}
		}
		// 3. �Ҽ��� ������ ��ȯ�Ѵ�.
		return count;
	}
	public static void main(String[] args) {
		PGS_�Ҽ�ã�� sol = new PGS_�Ҽ�ã��();
		System.out.println(sol.solution("17"));
	}
}

/*
 * 1. ���ڸ� �����ؼ� �Ҽ��� ������
 * �� �ڸ� ���ڰ� ���� ���� ������ ����� �ֽ��ϴ�. ����� ���� ������ �ٿ� �Ҽ��� �� �� ���� �� �ִ��� �˾Ƴ��� �մϴ�.
 * 
 * 2. �Ҽ��� ������ ��ȯ�ϴ� �Լ�
 * �� ���� ������ ���� ���ڰ� ���� ���ڿ� numbers�� �־����� ��, ���� �������� ���� �� �ִ� �Ҽ��� ����� return �ϵ��� solution�Լ��� �ϼ����ּ���
 * 
 * numbers�� ���� 1�̻� 7������ ���ڿ��Դϴ�.
 * numbers�� 0~9���� ���ڸ����� �̷���� �ֽ��ϴ�.
 * "013"�� 0,1,3 ���ڰ� ���� ���������� ������ִٴ� �ǹ��Դϴ�.
 * 
 * numbers return
 * "17"    3
 * "011"   2
 * 
 * - ���� �ܼ�ȭ�ϱ�
 *  1. �Ҽ�ã�� : ��� ������ ������ �����, �� �� �Ҽ��� ������ ��ȯ�϶�
 *  
 *  - ��͸� Ȱ���� solution
 *  1. ���� ���� : ���� ������ ��� ���� ������ ����Լ��� ���� �ϳ��� �����. 
 *  2. Set : set�� ������ Ȱ���Ͽ� �ߺ��Ǵ� ������ �����Ѵ�.
 *  3. �Ҽ����� �Ǵ� : ���� ������� ���ڰ� �Ҽ����� �Ǵ��Ѵ�, �Ҽ����� �Ǵ��ϰ� ������ �Ǵ��ϰ���� ���ڿ� ��Ʈ�� ���� �������� Ȯ���ϸ� �ȴ�.
 * 
 *  * 
 */
