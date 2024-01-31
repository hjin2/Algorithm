import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] result;
    public static boolean[] visited;
    public static int[] list = {0,1,2,3,4,5,6,7,8,9};
    public static int n;
    public static Long min = Long.MAX_VALUE;
    public static Long max = Long.MIN_VALUE;
    public static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        result = new int[n+1];
        visited = new boolean[10];
//        StringTokenizer st = new StringTokenizer(br.readLine());
        str = br.readLine();

        comb(0);


        if(max < Math.pow(10,n)){
            System.out.println("0" + max);
        }else{
            System.out.println(max);
        }
        if(min < Math.pow(10,n)){
            System.out.println("0" + min);
        }else{
            System.out.println(min);
        }

    }

    public static void comb(int r){
        if(r == n + 1){
            // 부등호랑 다 맞는지 확인
//            for(int i = 0 ; i < result.length ; i++){
//                System.out.print(result[i] + " ");
//            }
//            System.out.println();
            if(check()){
                String tmp = "";
                for(int i = 0 ; i < result.length ; i++){
                    tmp += result[i];
                }
                Long number = Long.parseLong(tmp);
                if( number < min){
                    min = number;
                }
                if( number > max){
                    max = number;
                }
            }
            return;
        }
        for(int i = 0 ; i < 10 ; i++) {
            if(!visited[i]) {
                result[r] = i;
                visited[i] = true;
                comb(r+1);
                visited[i] = false;
            }
        }

    }

    public static boolean check(){
        boolean possible = true;
        for(int i = 0 ; i < n ; i++){
            if(str.charAt(i * 2) == '<'){
                if(result[i] > result[i+1]){
                    possible = false;
                }
            }
            else if(str.charAt(i * 2) == '>'){
                if(result[i] < result[i+1]){
                    possible = false;
                }
            }
        }
        return possible;
    }
}