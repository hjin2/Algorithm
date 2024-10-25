import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<ArrayList<Integer>> list;
    public static int[] visited;
    public static boolean state;
    public static int v;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        for(int tc = 0 ; tc < k ; tc++){
            v = sc.nextInt();
            int e = sc.nextInt();
            list = new ArrayList<>();
            visited = new int[v + 1];
            state = false;

            for(int i = 0 ; i <= v ; i++){
                list.add(new ArrayList<Integer>());
            }

            for(int i = 0 ; i < e ; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                list.get(a).add(b);
                list.get(b).add(a);
            }

            for(int i = 1; i <= v ; i++){
                if(visited[i] == 0){
                    dfs(i, 1);
                }
            }

            if(state){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }


        }

    }

    private static void dfs(int i, int color) {
        if(state) return;
        visited[i] = color;
        for(int x : list.get(i)){
            if(visited[x] == color){
                state = true;
            }else if(visited[x] == 0){
                dfs(x, color * (-1));
            }
        }
    }
}