import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n : 병사들 k : 적어도 k명의 병사 이기도록 해야함
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;
        int[][] arr = new int[n][3];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int ctn = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int l = 0 ; l < n ; l++){
                    int cnt = 0;

                    for(int h = 0 ; h < n ; h++){
                        if(arr[i][0] >= arr[h][0] && arr[j][1] >= arr[h][1] && arr[l][2] >= arr[h][2]){
                            cnt++;
                        }
                    }

                    if(cnt >= k){
                        result = result > arr[i][0] + arr[j][1] + arr[l][2] ? (arr[i][0] + arr[j][1] + arr[l][2]) : result;
                    }
                }
            }
        }
        System.out.println(result);

    }
}