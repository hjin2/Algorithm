import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Ability implements Comparable<Ability> {
        int idx;
        int score;

        public Ability(int idx, int score){
            this.idx = idx;
            this.score = score;
        }


        @Override
        public int compareTo(Ability ability) {
            return ability.score - this.score ;
        }



    }

    public static int result = 0;
    public static Ability[][] abilities;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        abilities = new Ability[5][n];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 5 ; j++){
                abilities[j][i] = new Ability(i, Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0 ;  i < 5 ; i++){
            Arrays.sort(abilities[i]);
        }


        visited = new boolean[n];
        comb(0,0);
        System.out.println(result);



    }
    public static void comb(int sum, int idx){
        if(idx == 5){
            result = Math.max(result, sum);
            return;
        }
        for(int i = 0 ; i < 5 ; i++){
            if(!visited[abilities[idx][i].idx]) {
                visited[abilities[idx][i].idx] = true;
                comb((sum + abilities[idx][i].score), idx+1);
                visited[abilities[idx][i].idx] = false;
            }
        }
    }
}