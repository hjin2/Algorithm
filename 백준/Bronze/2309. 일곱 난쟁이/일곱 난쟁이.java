import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] arr = new int[9];
		for(int i = 0 ; i < 9; i++){
		    int n = sc.nextInt();
		    arr[i] = n;
		    sum += n;
		}
		
		int remain = sum - 100;
		int removeX = -1;
		int removeY = -1;
		for(int i = 0 ; i < 7 ; i++){
		 for(int j = i+1; j < 9 ; j++){
		     if(arr[i] + arr[j] == remain){
		         removeX = arr[i];
		         removeY= arr[j];
		         break;
		     }
		 }   
		}
		Arrays.sort(arr);
		for(int i = 0  ; i < 9 ; i++){
		    if(arr[i] == removeX || arr[i] == removeY ){
		        continue;
		    }
		    System.out.println(arr[i]);
		}
	}
}