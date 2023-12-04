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
	    int result = 0;
	    String s1 = sc.next();
	    String s2 = sc.next();
	    // 소문자가 주어짐 a-z : 26
	    int[] a1 = new int[26];
	    int[] a2 = new int[26];
	    
	    for(int i = 0 ; i < s1.length() ; i++){
	        a1[(int)s1.charAt(i)-'a']++;
	    }
	    	    
	    for(int i = 0 ; i < s2.length() ; i++){
	        a2[(int)s2.charAt(i)-'a']++;
	    }
	    
	    for(int i = 0 ; i < 26 ; i++){
	        if(a1[i]!=a2[i]){
	            result += Math.abs(a1[i] - a2[i]);
	        }
	    }
	    System.out.println(result);
	}
}
