import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;


    public static List<List<Integer>> arr;
    public static boolean[] visited;
    public static List<Integer> results;
    public static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        results = new ArrayList<>();

        visited = new boolean[n + 1];


        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i < n + 1; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.get(i).add(num);
        }

        // 자기 번호에서 시작해서 자기 번호로 끝나는 사이클 생기는 경우 해당 숫자 다 가능
        for (int i = 1; i < n + 1; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(results);
//        Set<Integer> set = new HashSet<>(results);
        System.out.println(results.size());
        for(int i : results){
            System.out.println(i);
        }

    }

    public static void dfs(int n, int start) {
        // n과 연결된 노드 찾기
        int num = arr.get(n).get(0);
        if (visited[num]) {// 근데 이미 방문한 곳인 경우
            // 시작점과 비교
            if (start == num) { // 동일하면 정답에 해당 연결요소 노드들 다 저장
                results.add(num);
                return;
            } else { // 동일하지 않으면 이건 안되는 경우들임
                return;
            }
        }
        visited[num] = true;
        dfs(num, start);
        visited[num] = false;
    }
}