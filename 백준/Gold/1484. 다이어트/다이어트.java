import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());

        int[] ls = new int[g+1];
        for(int i = 0 ; i < g+1 ; i++){
            ls[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        // 현재 + 기억 = 1, 약수들... , 자기자신 (단, 1은 생략 : 현재 + 기억 = 1 이 되려면 하나는 0이어야하니까)
        for(int i = 2 ; i <= g ; i++){
            if( g % i == 0 ){ // 15 % 1 == 0
                int target = i; // 이 값이 현재 + 기억
                int s = 1;    // 기억
                int e = target-1; // 현재
                while( s < e){
                    int sum = ls[s] + ls[e];
                    if(sum < target){
                        s++;
                    }else if(sum > target){
                        e--;
                    }else{
                        int remember = ls[s];
                        int now = ls[e];
                        if(now - remember == (g / i)){
                            result.add(now);
                        }
                        s++;
                        e--;
                    }
                }

            }
        }
        if(result.size() == 0)
            System.out.println(-1);
        else{
            for(int i = 0 ; i < result.size() ; i++){
                sb.append(result.get(i) + "\n");
            }
            System.out.println(sb);
        }
    }
}