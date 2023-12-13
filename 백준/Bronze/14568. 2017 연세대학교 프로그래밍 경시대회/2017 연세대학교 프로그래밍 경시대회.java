import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		for(int a = 1; a < 101 ; a++){
		    for(int b = 1 ; b < 101 ; b++){
		        for(int c = 1 ; c < 101 ; c++){
		            if((a >= 1 && b >= 1 && c >= 1) && (a % 2 == 0) && (b + 2 <= c) && (a + b + c == n)){
		                result++;
		            }
		        }
		    }
		}
		
		System.out.println(result);
	}
}