import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, k;
    public static int[] money;
    public static boolean[] visited;
    public static int min = 1000000000; // 연결요소 내의 친구비
    public static int sum = 0;
    public static List<List<Integer>> relation = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        money = new int[n + 1];
        visited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i < n + 1 ; i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n + 1 ; i++){
            relation.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation.get(a).add(b);
            relation.get(b).add(a);
        }



        // 각 연결요소의 가장 작은 값 찾기
        for(int i = 1 ; i < n + 1 ; i++){
            if(visited[i]){
                continue;
            }
            // i번째 친구는 친구가 아니였음 친구하러감
            min = 100000000;
            visited[i] = true;
            dfs(i); // 이거끝나면 i와 연결된 연결요소들 중 최솟값이 min에 저장되어 있을것이다.
            sum += min;
        }

        if(sum > k){
            System.out.println("Oh no");
        }else{
            System.out.println(sum);
        }
    }
    public static void dfs(int n){
        min = Math.min(money[n], min);
        for(int i = 0 ; i < relation.get(n).size() ; i++){
            if(visited[relation.get(n).get(i)]){
                continue;
            }
            min = Math.min(min, money[relation.get(n).get(i)]); // 친구비 갱신시키기
            visited[relation.get(n).get(i)] = true; // 친구가 되었다.
            dfs(relation.get(n).get(i)); // 그리고 얘랑 연결된 친구들도 확인
        }
    }
}