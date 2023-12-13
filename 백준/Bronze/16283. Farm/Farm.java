import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    int w = Integer.parseInt(st.nextToken());
	    
	    int resultX = -1;
	    int resultY = -1;
	    int have = 0;
	    
	    for(int x = 1 ; x < n ; x++){
	        int y = n - x;
	        if(a * x + b * y == w){
	            if(have == 1){
	                have = -1;
	                break;
	            }
	            have++;
	            resultX = x;
	            resultY = y;
	        }
	    }
	    
	    if(have== -1 || have == 0){
    		System.out.println(-1);
	    }
    	else{
    	    System.out.print(resultX + " " + resultY);
    	}
	}
}