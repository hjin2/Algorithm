import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int x, y;
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[][] dist;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0}; // 우 하 좌 상
    public static int depth = -1;
    public static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new char[x][y];
        visited = new boolean[x][y];
        dist = new int[x][y];
        // 다음ㅇ꺼 해보기

        for(int i = 0 ;  i < x ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < y ; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        // L -> L 까지 거리가 가장 긴 곳 찾기
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y; j++){
                if(arr[i][j] == 'L'){
                    visited = new boolean[x][y];
                    depth = 0;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    bfs();
                }
            }
        }

        int result = -1;

        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){

                result = result < dist[i][j] ? dist[i][j] : result;
            }
        }
        System.out.println(result);


    }
    public static void bfs(){
        while(!queue.isEmpty()){
            depth++;
            int depthSize = queue.size();
            while(depthSize-- > 0){
                int[] now = queue.poll();
                int nowX = now[0];
                int nowY = now[1];

                for(int i = 0 ; i < 4; i++){
                    int nx = nowX + dx[i];
                    int ny = nowY + dy[i];


                    if(nx < 0 || nx >= x || ny < 0 || ny >= y){ // 범위 x이상 ;; 아주 기초적인걸 틀림
                        continue; // 범위 벗어나면 안되고
                    }
                    if(visited[nx][ny]){
                        continue; // 이미 방문한 곳이면 안되고
                    }
                    if(arr[nx][ny] == 'W'){
                        continue; // 물이면 이동할 수 없고
                    }
                    // 범위 안이고 방문 안했고 땅인곳으로 움직일거임
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    if(dist[nx][ny] < depth) {
                        dist[nx][ny] = depth;
                    }
                }
            }
        }
    }
}