import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int result = -1;
            int[] arr = new int[100];
            int idx = 0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                arr[idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
            for(int x = 0 ; x < idx ; x++){
                for(int y = 0 ; y < idx ; y++){
                    if(x >= y){
                        continue;
                    }
                    for(int z = 1 ; z <= Math.min(arr[x],arr[y]) ; z++){
                        if( arr[x] % z == 0 && arr[y] % z == 0){
                            result = result < z ? z : result;
                        }
                    }
                }
            }
            System.out.println(result);
        }

    }
}