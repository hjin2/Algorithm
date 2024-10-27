import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] work;
    public static int[] time;
    public static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        // 초기화
        work = new int[n + 1];
        time = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 입력을 통해 작업 시간 및 선행 작업 정보 저장
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            work[i] = Integer.parseInt(st.nextToken());  // 작업 시간
            int numPreTasks = Integer.parseInt(st.nextToken());  // 선행 작업 수
            for (int j = 0; j < numPreTasks; j++) {
                int preTask = Integer.parseInt(st.nextToken());
                graph.get(i).add(preTask);  // 선행 작업 번호 저장
            }
        }

        // 작업 시간 계산
        for (int i = 1; i <= n; i++) {
            int maxTime = 0;  // 선행 작업의 최대 완료 시간
            for (int preTask : graph.get(i)) {
                maxTime = Math.max(maxTime, time[preTask]);
            }
            time[i] = maxTime + work[i];
        }

        // 결과: 모든 작업이 완료되는 데 걸리는 최종 시간
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, time[i]);
        }
        System.out.println(result);
    }
}