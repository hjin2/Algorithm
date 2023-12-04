/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String result ="";
		
		for(int i = 0 ; i < str.length() ; i++){
		    String tmp = "";
		    if((int)str.charAt(i)>=97 && (int)str.charAt(i)<=122){
    		    tmp = String.valueOf(str.charAt(i));
    		    tmp = tmp.toUpperCase();
    		}else{
    		    tmp = String.valueOf(str.charAt(i));
    		    tmp = tmp.toLowerCase();
    		}
    		result += tmp;
		}
		System.out.println(result);
	}
}
