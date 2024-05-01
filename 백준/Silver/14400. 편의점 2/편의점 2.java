import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] xy = new int[n][2];

        StringTokenizer st = null;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xy, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int resultX = xy[(n-1)/2][0];

        Arrays.sort(xy, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });

        int resultY = xy[(n-1) / 2][1];


        Long result = 0L;
        for(int i = 0 ; i < n ; i++){
            result += (Math.abs(resultX - xy[i][0]) + Math.abs(resultY - xy[i][1]));
        }

        System.out.println(result);
    }
}