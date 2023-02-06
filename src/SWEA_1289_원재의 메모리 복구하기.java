package algo;



import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class SWEA_메모리 {

	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String num;								                // 테스트케이스 하나하나.. 1010101111010101 / 10 / 11010101010 등을 담을 변수
			num=sc.next();						              	// 한줄 입력 받기
			char[] numlist = num.toCharArray();     	// string을 char배열로 바꾼다.
			int result = 0;							              // 최종 결과
			if(numlist[0]!='0') {				            	// 첫번째 나오는 수가 0이 아니면 즉 1이면 결과값에 1을 더해준다 (이때 여기서 0은 숫자가 아니라 문자이다..!!!)
				result = 1;						                	// 왜냐하면 처음에 초기화상태가 모든 bit가 0000으로 0인데 첫번째가 1이면 1로 한번 변경을 해줘야하기 때문이다.
			}else {								                  	// 첫번째 나오는 수가 0이면 더해줄 필요가 없다. 따로 변경할 일이 없으니까
				result = 0;
			}
			char comp = numlist[0];			          		// 첫번째수와 뒤의 자리 숫자들을 비교한다.
				
			for(int i = 1 ; i <numlist.length ;i++) {	// comp변수와 배열 1번째부터 끝까지 비교한다.
				if(numlist[i] != comp) {			        	// 만약에comp변수와 배열에 있는 숫자가 다르면
					result += 1;						              // 1을 더해준다. 
				}
				comp = numlist[i];						          // 자기자신을 cmp로두고 그 다음에 있는 수와 비교한다
			}
			System.out.println("#" + test_case + " " + result);
			
			
		}
	}
}
