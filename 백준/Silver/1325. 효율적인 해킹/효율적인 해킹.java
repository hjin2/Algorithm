import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<Integer>[] list;
    public static boolean[] visited;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 컴퓨터는 1부터 N까지
        int m = Integer.parseInt(st.nextToken());   // 신뢰관계 갯수

        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }


        // list돌면서 리스트인덱스번호를 해킹했을때 해킹할 수 있는 애들 갯수 세기
        result = new int[n + 1];
        for(int i = 1 ; i <= n; i++){
            visited = new boolean[n+1];
            bfs(i);
        }

        int max = Arrays.stream(result).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            if(result[i] == max){
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for(int i : answer){
            System.out.print(i + " ");
        }
        System.out.println();


//        int max = 0;
//        for(int i = 0 ; i < n+1; i++){
//            max = Math.max(max,result[i]);
//        }
//        for(int i = 0 ; i < n+1 ;i++){
//            if(max==result[i])
//                System.out.print((i-1) + " ");
//        }
    }
    public static void bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(idx);
        visited[idx] = true;


        while(!queue.isEmpty()){
            int pick = queue.poll();

            for(int num : list[pick]){
                if(visited[num]) continue;
                visited[num] = true;
                queue.add(num);
                result[num]++;
            }
        }



    }
}