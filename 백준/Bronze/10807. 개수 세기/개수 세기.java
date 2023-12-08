import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
		    arr[i] = sc.nextInt();
		}
		int t = sc.nextInt();
		int result = 0;
		for(int i = 0 ; i < n; i++){
		    if(arr[i]==t){
		        result++;
		    }
		}
		System.out.println(result);
	}
}
