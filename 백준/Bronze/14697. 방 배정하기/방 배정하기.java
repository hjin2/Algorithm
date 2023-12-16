import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		for(int x = 0 ; x <= n / a + 1 ; x++){
		    for(int y = 0 ; y <= n / b + 1 ; y++){
		        for(int z = 0 ; z <= n / c + 1 ; z++){
		            if(a*x + b*y + c*z == n){
		                System.out.println(1);
		                return;
		            }
		        }
		    }
		}
		System.out.println(0);
	}
}