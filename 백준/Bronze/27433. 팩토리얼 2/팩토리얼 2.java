import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		
		System.out.println(rec(n));
	}
	public static long rec(int n){ // 1부터 n까지 곱한 값 을 반환하는 함수
	    if(n == 1 || n == 0){
	        return 1;
	    }
	    return n * rec(n-1);
	    
	}
}