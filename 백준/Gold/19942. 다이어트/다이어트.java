import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int[] target;
    public static int n;
    public static int result = Integer.MAX_VALUE;
    public static String resultNums = "";
    public static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][5];
        target = new int[4];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 5 ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0,0,0,0,0,0, "");
        if(resultNums.equals("")){
            System.out.println(-1);
        }else{
            System.out.println(result);
            Collections.sort(list);
            for(int i = 1 ; i < list.get(0).length() ; i++){
                System.out.print(list.get(0).charAt(i));
            }
        }
    }
    public static void recur(int rec, int a, int b, int c, int d, int cost, String str){
        if(rec == n){
//            System.out.printf("%d %d %d %d %d %d %s\n",rec, a,b,c,d,cost,str);
            if(target[0] <= a && target[1] <= b && target[2] <= c && target[3] <= d){
                if(result > cost) {
                    list.clear();
                    list.add(str);
                    result = cost;
                    resultNums = str;
                }
                if(result == cost){
                    list.add(str);
                }
            }
            return;
        }


        recur(rec + 1, a + arr[rec][0], b + arr[rec][1],c + arr[rec][2],d + arr[rec][3],cost + arr[rec][4], str + " " + (rec + 1));


        recur(rec + 1, a, b, c, d, cost, str);

    }
}

//        for(int i = 0 ; i < n ; i++){
//            for(int j = 0 ; j < 5 ; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }