import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String str = sc.next();
	    
	    int max = -1;
	    str = str.toLowerCase();
	    int[] arr = new int[26];
	    for(int i = 0 ; i < str.length() ;i++){
	        arr[(int)str.charAt(i)-'a']++;
	    }
	    for(int i = 0 ; i < 26 ; i++){
	     max = max < arr[i] ? arr[i] : max;   
	    }

	    boolean have = false;
	    int result = -1;
	    for(int i = 0 ; i < 26; i++){
	        if(arr[i] == max && have){
	            System.out.println("?");
	            return;
	        }
	        if(arr[i] == max){
	            have = true;
	            result = i;
	        }
	    }
	    System.out.print((char)((result)+'A'));
	}
}
