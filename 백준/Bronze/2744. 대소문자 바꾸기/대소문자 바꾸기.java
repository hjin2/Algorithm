import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String result ="";
		
		for(int i = 0 ; i < str.length() ; i++){
		    int change;
		    if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
		        int tmp = str.charAt(i) - 'a'; // 현재 알파벳이 a!!!로 부터 얼마나 떨어져 있는지 확인
		        change = 'A' + tmp; // 대문자 A에서 떨어진 만큼을 더한다 !
    		}else{
    		    int tmp = str.charAt(i) - 'A';
    		    change = 'a' + tmp;
    		}
    		result += (char)change;
		}
		System.out.println(result);
	}
}
