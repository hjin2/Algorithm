import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    // 서로 다른 숫자 세개다 , 그리고 0이없음...
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] arr = new boolean[1000];
		for(int i = 0 ; i < n ; i++){
		    int cmp = sc.nextInt();
		    int strike = sc.nextInt();
		    int ball = sc.nextInt();
		    String cmpN = Integer.toString(cmp);
		    for(int k = 100 ; k < 1000 ; k++){
		        if(i!=0 && arr[k] == false){
		            continue;
		        }
		        if(Integer.toString(k).charAt(0) == Integer.toString(k).charAt(1) || 
		        Integer.toString(k).charAt(0) == Integer.toString(k).charAt(2) || 
		        Integer.toString(k).charAt(1) == Integer.toString(k).charAt(2)){
		            continue;
		        }
		        if(Integer.toString(k).charAt(0) == '0' || Integer.toString(k).charAt(1) == '0' || Integer.toString(k).charAt(2) == '0' ){
		            continue;
		        }
		        String arrN = Integer.toString(k);
		        int tmpS = 0;
		        int tmpB = 0;
		        for(int idx = 0 ; idx < 3 ; idx++){
		            for(int kidx = 0 ; kidx < 3 ; kidx++){
		                if(cmpN.charAt(idx) == arrN.charAt(kidx) && idx == kidx){
		                    tmpS += 1;
		                }else if(cmpN.charAt(idx) == arrN.charAt(kidx) && idx != kidx){
		                    tmpB += 1;
		                }
		            }
		        }
		        if(tmpS == strike && tmpB == ball){
		            arr[k] = true;
		        }
		        else{
		            arr[k] = false;
		        }
		    }
		}
		int result = 0;
		for(int i = 100 ;  i < 1000 ; i++){
		    if(arr[i] == true){
		        //System.out.print(i + " ");
		        result++;
		    }
		}
		System.out.println(result);
	}
}