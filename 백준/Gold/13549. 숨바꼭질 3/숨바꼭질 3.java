import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static int result = Integer.MAX_VALUE;
    public static Queue<int[]> queue = new LinkedList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        // 시작점에서 bfs 돌리기
        bfs(n);
        System.out.println(result);
    }
    public static void bfs(int n){
        queue.add(new int[]{n, 0});
        visited[n] = true;

        while(!queue.isEmpty()){
            int[] top = queue.poll();

            if(top[0] == k){
                result = result > top[1] ? top[1] : result;
            }

            // top에서 갈 수 있는 곳
            int[] near = { top[0] * 2, top[0] - 1, top[0] + 1};

            for(int i = 0 ; i < 3 ; i++){
                // 범위를 나가면 안됨
                if(near[i] < 0 || near[i] > 100000){
                    continue;
                }
                // 방문한 곳이면
                if(visited[near[i]]){ // near[i]가 방문한 곳임 visted[i] 아님!!!!!
                    continue;
                }
                if(i == 0){
                    queue.add(new int[]{near[i], top[1]}); // near[1]이 아니라 top[1]!!!!!
                }else{
                    queue.add(new int[]{near[i], top[1] + 1});
                }
                visited[near[i]] = true;
            }
        }
    }
}