import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		
		int sum = 0;
		for(int i = 0 ; i < 10 ; i++){
		    int n = sc.nextInt();
		    sum += n;
		    arr[i] = sum;

		}

		int min = Integer.MAX_VALUE;
		int idx = -1;
		int result = -1;
		for(int i = 0 ; i < 10 ; i++){
		    if(Math.abs(arr[i]-100) <= min){
		        result = arr[i];
		        min = Math.abs(arr[i]-100);
		    }
		}
		System.out.print(result);
	}
}