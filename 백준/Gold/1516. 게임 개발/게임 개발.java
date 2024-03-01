import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<List<Integer>> buildings;
    public static int[] T;  // 빌딩 짓는데 걸리는 시간
    public static int N;    // 빌딩 개수
    public static int[] results;    // 결과
    public static int[] indegree;   // 진입차수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        indegree = new int[N + 1];

        // 빌딩 들 간의 연결
        buildings = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            buildings.add(new ArrayList<>());
        }
        results = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());    // 빌딩 짓는데 걸리는 시간
            results[i] = T[i];

            int cnt = 0;    // i번 빌딩을 짓기위해 사전에 지어야 할 건물 개수 (진입차수)
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken()); // 진입노드
                if (tmp != -1) {
                    buildings.get(tmp).add(i); // tmp -> i
                    cnt++;
                }
            }
            indegree[i] = cnt;  // 진입차수 저장
        }



        // 위상정렬
        // 1. 진입차수가 0인 것들을 큐에 넣는다.
        // 2. 큐에서 한 개를 뽑은 후, (=> 즉 건물을 짓는다. T[i]만큼 시간이 걸린다.)
        //      1. T[i]와 연결된 다른 건물들 차수를 1씩 줄인다.
        //      2. result[연결된 다른 건물들] = max(result[연결된 다른 건물들] + T[i], result[연결된 다른 건물들])
        //      3. 이때 차수가 0이 되면 큐에 담는다
        // 큐가 빌때까지 진행한다.

        // 생각을 거의 정답과 동일하게 했으나, 저장할 때 잘 못함..

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            if(indegree[i] == 0){ // 차수가 0인 것을 큐에 넣는거니까 indegree가 0인 수
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll(); // 큐에서 한개를 뽑는다. 큐에 있다는 건 차수가 0이라는 뜻


            for(int i = 0 ; i < buildings.get(now).size() ; i++){ // 진입차수가 0인 노드와 연결된 노드들
                int next = buildings.get(now).get(i);

//                System.out.println("현재 노드 : " + next);
//                System.out.printf("T[%d] : %d \tresults[%d] : %d \tresults[%d] : %d\n",next,T[next],now,results[now],next,results[next]);

                results[next] = Math.max(T[next] + results[now], results[next]); // 연결된 노드를 만드는게 걸리는 시간
//                System.out.println("결국 저장된 값 : " + results[next]);
                indegree[next] -= 1; // 차수 제거
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }

        }

        for(int i = 1 ; i < results.length ; i++){
            System.out.println(results[i] + " ");
        }




    }
}