
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	    int result = 0;
	    
	    
	    char[][] arr = new char[n][m];
	    for(int i = 0 ; i < n; i++){
	        String tmp = br.readLine();
	        for(int j = 0 ; j < m; j++){
	            arr[i][j] = tmp.charAt(j);
	        }
	    }
	    
	 
	    
	    // 처음 생각 방법
	    // 전체 배열을 돌면서 X인 곳 가로를 true로 세로를 true로 설정
	    // 그랬더니 4 4 .... .... .... .... 예시에서 8개가 나옴
	    
	    int max = n < m ? m : n;
	    
	    int[] row = new int[n];
	    int[] col = new int[m];
	    
	    
	    // 각 행에 있는지

	    for(int i = 0 ; i < n ; i++){
	        boolean garo = false;
	        for(int j = 0 ; j < m; j++){
	            if(arr[i][j] == 'X'){
	                // i행에 X가 있다.
	                garo = true;
	                row[i] = 1;
	            }
	        }
	    }
	    
	    
	    for(int i = 0 ; i < m ; i++){
	        boolean sero = false;
	        for(int j = 0 ; j < n; j++){
	            if(arr[j][i] == 'X'){
	                sero = true;
	                col[i] = 1;
	            }
	        }
	    }	 
	    
	   // System.out.println("가로");
	    int rowtmp = 0;
	    for(int i = 0 ; i < n; i++){
	       //  System.out.print(row[i] + " ");
	         if(row[i] == 0)
    	         rowtmp++;
	    }
	    
	   // System.out.println("\n세로를로");
	    int coltmp = 0;
	    for(int i = 0 ; i < m; i++){
	       // System.out.println(i);
	       //  System.out.print(col[i] + " ");
	         if(col[i] == 0)
    	         coltmp++;
	    }
	    

	    if(rowtmp == coltmp){
	        result = rowtmp;
	    }else{
	        int large = rowtmp < coltmp ? coltmp : rowtmp;

	        result = large;
	    }

	    
	    System.out.println(result);
	}
}
