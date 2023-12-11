
import java.util.*;
import java.io.*;
public class Main
{
    
    public static int result = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[20];
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < tc ; i++){
		    arr = new int[20];
		    result = 0;
		    st = new StringTokenizer(br.readLine());
		    int test = Integer.parseInt(st.nextToken());
		    for(int j = 0 ; j < 20 ; j++){
		        int kid = Integer.parseInt(st.nextToken()); // j번째 애기
		        boolean have = false;
		        for(int k = 0 ; k < j ; k++){ // 0부터 j-1번째 애기
		            if(arr[k] > kid){ // 더 큰 애기가 있으면
		                have = true;
		                for(int h = k ; h < j+1 ; h++){
		                    int tmp = arr[h];
		                    arr[h] = kid;
		                    kid = tmp;
		                    result++;
		                }
		                result-=1;
		                break;
		            }
		        }
		        if(!have){
		            arr[j] = kid;
		        }
		    }
		    System.out.println((i+1) + " " + result);
		}
	}
	

}