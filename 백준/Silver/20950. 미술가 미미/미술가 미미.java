import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n, rg, gg, bg;
    public static int[][] colors;
    public static int result = Integer.MAX_VALUE;
    public static List<Integer> pick = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        colors = new int[n][3];

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        rg = Integer.parseInt(st.nextToken());
        gg = Integer.parseInt(st.nextToken());
        bg = Integer.parseInt(st.nextToken());

        for(int i = 2 ; i <= 7 ; i++){
            comb(n,i,0);
        }


        System.out.println(result);

    }
    public static void comb(int n, int r, int now){
        if(pick.size() == r){
            int cr = 0;
            int cg = 0;
            int cb = 0;
            for(int i = 0 ; i < pick.size() ; i++){
                cr += colors[pick.get(i)][0];
                cg += colors[pick.get(i)][1];
                cb += colors[pick.get(i)][2];
            }
            cr = cr / pick.size();
            cg = cg / pick.size();
            cb = cb / pick.size();

            result = Math.min(Math.abs(rg - cr) + Math.abs(gg - cg) + Math.abs(bg - cb), result);
            return;
        }
        for(int i = now ; i < n ; i++){
            pick.add(i);
            comb(n, r, i + 1);
            pick.remove(pick.size() - 1);
        }
    }
}