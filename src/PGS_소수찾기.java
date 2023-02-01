import java.util.HashSet;
import java.util.Iterator;


public class PGS_소수찾기 {
	HashSet<Integer> numberSet = new HashSet<>();
	
	public boolean isPrime(int num) {
		// 1. 0과 1은 소수가 아니다.
		if(num==0 || num==1) {
			return false;
		}
		// 2. 에라토스테네스의 체의 limit을 계산한다. limit은 71인 값을 했을때는 8까지만 계산하면 된다는 거 (루트씌운 값까지만)
		// 여기까지 왔다는 것은 0과 1이 아닌 숫자가 들어왔다는거다.
		int lim  = (int)Math.sqrt(num); // 어디까지 배수인지 확인할거냐면 루트를 씌운 값까지만 확인할것이다.
		
		// 3. 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인한다.
		for(int i = 2; i <= lim ; i++) {
			if(num % i == 0 )
				return false;
		}
		return true;
	}
	public void recursive(String com, String others) { // com : 여태까지 조합된 숫자를 의미 , others : 여태까지 쓰지 않은 숫자
		// 1. 현재 조합을 set에 추가한다. 
		// combination이 만들어져서 재귀함수 안에 들어와있을텐데 현재 재귀함수 안에서 만들어진 combination을 내가 set에 한 번 추가한다.
		if(!com.equals(""))
			numberSet.add(Integer.valueOf(com));
		
		
		// 2. 남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
		for(int i = 0 ; i < others.length() ; i++) {
			recursive(com + others.charAt(i), others.substring(0,i) + others.substring(i+1));
		}
		
	}
	public int solution(String numbers) {
		int count = 0;
		// 1. 모든 조합의 숫자를 만든다.
		recursive("",numbers); // ""여태까지 조합한 숫자는 아직 없는거다. 남아있는 숫자는 우리가 전달받은 숫자 전체 numbers
		
		System.out.println(numberSet);
		
		// 2. 소수의 개수만 센다.
		Iterator<Integer> it = numberSet.iterator();
		while(it.hasNext()) {
			int number = it.next();
			if(isPrime(number)) {
				count++;
			}
		}
		// 3. 소수의 개수를 반환한다.
		return count;
	}
	public static void main(String[] args) {
		PGS_소수찾기 sol = new PGS_소수찾기();
		System.out.println(sol.solution("17"));
	}
}

/*
 * 1. 숫자를 조합해서 소수를 만들어라
 * 한 자리 숫자가 적힌 종이 조각이 흩어져 있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 
 * 2. 소수의 개수를 반환하는 함수
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇개인지 return 하도록 solution함수를 완성해주세요
 * 
 * numbers는 길이 1이상 7이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0,1,3 숫자가 적힌 종이조각이 흩어져있다는 의미입니다.
 * 
 * numbers return
 * "17"    3
 * "011"   2
 * 
 * - 문제 단순화하기
 *  1. 소수찾기 : 모든 숫자의 조합을 만들고, 그 중 소수의 개수를 반환하라
 *  
 *  - 재귀를 활용한 solution
 *  1. 숫자 조합 : 생성 가능한 모든 숫자 조합을 재귀함수를 통해 하나씩 만든다. 
 *  2. Set : set의 개념을 활용하여 중복되는 조합을 제거한다.
 *  3. 소수인지 판단 : 지금 만들어진 숫자가 소수인지 판단한다, 소수인지 판단하고 싶으면 판단하고싶은 숫자에 루트를 씌운 값까지만 확인하면 된다.
 * 
 *  * 
 */
