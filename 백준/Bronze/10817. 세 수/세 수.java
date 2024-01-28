import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
 
		in.close();
        
		if (a >= b) {
			if (a >= c) {
				if (b >= c)
					System.out.println(b);
				else
					System.out.println(c);
			} else
				System.out.println(a);
		} else {
			if (c <= b) {
				if (c <= a)
					System.out.println(a);
				else
					System.out.println(c);
			} else
				System.out.println(b);
		}
	}
}