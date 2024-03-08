import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Road{
    int x;
    int y;
    public Road(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Node {
    int num;
    int w;
    public Node(int num, int w){
        this.num = num;
        this.w = w;
    }

}

public class Main {
    public static int n; // n개의 노드, n-1개의 간선을 입력받음
    public static int a, b; // a로봇, b로봇
    public static int[] aroute;
    public static int[] broute;
    public static List<Road> roads;
    public static boolean[] visited;
    public static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        aroute = new int[n + 1];
        broute = new int[n + 1];
        visited = new boolean[n + 1];
        roads = new ArrayList<>(); // 마지막에 최솟값 구할때 쉽게 빼쓰기 위한 간선 정보들

        for(int i = 0 ; i < n + 1 ; i++){
            graph.add(new ArrayList<>());
        }


        for(int i = 0 ; i < n - 1 ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Road road = new Road(x,y);
            roads.add(road);


            graph.get(x).add(new Node(y,w));
            graph.get(y).add(new Node(x,w));
        }
        
        if(n == 1){
            System.out.println(0);
            System.exit(0);
        }
        if(a == b){
            System.out.println(0);
            System.exit(0);
        }

        // a로봇이 각각의 노드에 방문하는데 걸리는 시간 저장
        visited[a] = true;
        dfs(a);


        // b로봇이 각각의 노드에 방문하는데 걸리는 시간 저장
        visited = new boolean[n + 1];
        visited[b] = true;
        dfs2(b);


        int result = Integer.MAX_VALUE;
        // 경로 n개를 돌면서 최솟값을 정답으로 갱신
        for(Road road : roads){
            int x = road.x;
            int y = road.y;

            int num = Math.min(aroute[x] + broute[y], aroute[y] + broute[x]);
            result = result > num ? num : result;
        }

        System.out.println(result);
    }
    public static void dfs(int n){
        for(Node node : graph.get(n)){
            int num = node.num;
            int w = node.w;

            if(visited[num]){
                continue;
            }
            // 이 node를 가는데 걸리는 시간은 arout[노드번호] = aroute[n] + w;
            aroute[num] = aroute[n] + w;
            visited[num] = true;
            dfs(num);
        }
    }

    public static void dfs2(int n){
        for(Node node : graph.get(n)){
            int num = node.num;
            int w = node.w;

            if(visited[num]){
                continue;
            }
            // 이 node를 가는데 걸리는 시간은 arout[노드번호] = aroute[n] + w;
            broute[num] = broute[n] + w;
            visited[num] = true;
            dfs2(num);
        }
    }
}