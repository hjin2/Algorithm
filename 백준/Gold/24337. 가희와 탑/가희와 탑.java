import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Math.max(a,b);
        int min = Math.min(a,b);

        if(Math.max(a,b) > n){
            System.out.println(-1);
            System.exit(0);
        }
        if(a == 1 && b == 1 && n == 1){
            System.out.println(1);
            System.exit(0);
        }


        List<Integer> buildings = new ArrayList<>();

        for(int i = 1 ; i <= (a - 1) ; i++){
            buildings.add(i);
        }
        buildings.add(Math.max(a,b));
        for(int i = (b - 1) ; i >= 1 ; i--){
            buildings.add(i);
        }

        if(buildings.size() > n){
            System.out.println(-1);
            System.exit(0);
        }else{
            System.out.print(buildings.get(0) + " ");
            for(int i = 0 ; i < n - (buildings.size()) ; i++){
                System.out.print(1 + " ");
            }
            for(int i = 1 ; i < buildings.size() ; i++){
                System.out.print(buildings.get(i) + " ");
            }
        }



    }
}