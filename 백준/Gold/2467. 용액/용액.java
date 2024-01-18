import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;  i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int s = 0;
        int e = n-1;
        int results = 0;
        int resulte = n-1;
        long min = 2000000009L; // 최대 1,000,000,000니까 2배보다 더 크게 min설정, 그러면 무조건 갱신

        while( s < e ){ //
            if(arr[s] <= 0 && arr[e] <= 0){ // 둘 다 음수인 경우
                if(Math.abs(arr[s] + arr[e]) <= min){
                    results = s;
                    resulte = e;
                    min = Math.abs(arr[s] + arr[e]);
                }
                s++;
            }else if(arr[s] >= 0 && arr[e] >= 0){
                if(arr[s] + arr[e] <= min){
                    results = s;
                    resulte = e;
                    min = Math.abs(arr[s] + arr[e]);
                }
                e--;
            }
            else if(Math.abs(arr[s]) >= Math.abs(arr[e])){
                if(Math.abs(arr[s] + arr[e]) <= min ){
                    results = s;
                    resulte = e;
                    min = Math.abs(arr[s] + arr[e]);
                }
                s++;
            }else if(Math.abs(arr[s]) < Math.abs(arr[e])){
                if(Math.abs(arr[s] + arr[e]) <= min ){
                    results = s;
                    resulte = e;
                    min = Math.abs(arr[s] + arr[e]);
                }
                e--;
            }
        }


        if(arr[results] < arr[resulte])
            System.out.println(arr[results] + " " + arr[resulte]);
        else
            System.out.println(arr[resulte] + " " + arr[results]);


    }
}