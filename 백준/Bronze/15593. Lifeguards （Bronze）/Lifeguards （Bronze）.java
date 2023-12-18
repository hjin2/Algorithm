import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] times = new int[n*2];
		int[] count = new int[1001];
		
		for(int i = 0 ; i < n ; i++){
		    int start = sc.nextInt();
		    int end = sc.nextInt();
		    times[2*i] = start;
		    times[2*i+1] = end;
		    for(int k = start ; k < end ; k++){
		        count[k] += 1;
		    }
		}
		int max = -1;
		int result = 0;
		int cow = 0;
		while(cow < n){
	    	for(int i = 0 ; i < 1001 ; i++){
		       if( i >= times[2*cow] && i < times[2*cow+1]){
		          if(count[i] > 1){
		               result++;
		            }else{
		             continue;
		          }
		      }else{
		       if(count[i] >= 1){
		           result++;
		       }
		      }
	    	}
		max = max < result ? result : max;
		result = 0;
		cow++;
		}
		System.out.println(max);
		
		
		
	}
}