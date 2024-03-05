import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Cloud{
    int x;
    int y;
    public Cloud(int x, int y){
        this.x =x;
        this.y = y;
    }
}
public class Main {
    public static int n,m;
    public static int[][] arr;
    // 구름의 위치
    // 1. 객체
    // 2. 입력받은 NxN 사이즈만큼 true,false로 구름 존재 저장
    public static boolean[][] exist; // 구름의 존재유무 배열
    public static List<Cloud> clouds;

    // 1번인덱스용으로 (0,0), ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    public static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
    public static int[] dy = {0,-1,-1,0,1,1,1,0,-1};

    // 대각선 방향
    public static int[] dx2 = {-1,-1,1,1};
    public static int[] dy2 = {-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        exist = new boolean[n][n];
        clouds = new ArrayList<>();

        for(int i  = 0 ; i < n ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 함수 구현 전에 데이터 저장하기
        exist[n-1][0] = true;
        exist[n-1][1] = true;
        exist[n-2][0] = true;
        exist[n-2][1] = true;

        clouds.add(new Cloud(n-1,0));
        clouds.add(new Cloud(n-1,1));
        clouds.add(new Cloud(n-2,0));
        clouds.add(new Cloud(n-2,1));

//        for(int i = 0 ; i < clouds.size() ; i++){
//            System.out.println(clouds.get(i).x + " " + clouds.get(i).y);
//        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s =  Integer.parseInt(st.nextToken());
            move(d,s);
            rain();
            watercopy();
            makecloud();
        }

        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                result += arr[i][j];
            }
        }
        System.out.println(result);

    }

    private static void makecloud() {
        // 현재 위치에 구름이 없으면
        // 물이 2이상인지 확인하고 2이상이면 물의양 2줄이고, 구름만들기
        List<Cloud> aftercloud = new ArrayList<>();
        for(int i = 0 ; i < n;  i++){
            for(int j = 0 ; j < n ; j++){
                if(!exist[i][j] && arr[i][j] >= 2){
                    arr[i][j] -= 2;
                    aftercloud.add(new Cloud(i,j));
                }
            }
        }
        clouds = aftercloud;
        get_exist();
    }

    private static void watercopy() {
        // 물복사버그쓸 때는 변하는 원래배열을 복사해놓고 변화시킨다
        // 현재 상태를 그대로 복사한다
        int[][] copy_arr = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                copy_arr[i][j] = arr[i][j];
            }
        }
        // 2에서 물이 증가한 칸 즉 구름이 있었던 칸에 물복사 마법 시전
        // 대각선에 물이 있는 바구니 수만큼 물의 양 증가
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(exist[i][j]){
                    for(int k = 0 ; k < 4 ; k++){
                        int nx  = i + dx2[k];
                        int ny =  j + dy2[k];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                            continue;
                        }
                        if(copy_arr[nx][ny] != 0){
                            arr[i][j]++;
                        }
                    }
                }
            }
        }
    }

    private static void rain() {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(exist[i][j]){
                    arr[i][j]++;
                }
            }
        }
    }

    private static void move(int d, int s) {
        // 기존 구름에서 s만큼 이동시켜야함
        List<Cloud> aftermove = new ArrayList<>();
        for(Cloud cloud : clouds){
            int x = cloud.x;
            int y = cloud.y;
            for(int i = 1 ; i <= s ; i++){
                x = (x + dx[d] + n) % n;
                y = (y + dy[d] + n) % n;
            }
            aftermove.add(new Cloud(x, y));
        }
        clouds = aftermove;
        get_exist();
    }

    // cloud배열(cloud리스트) 기반으로 exist배열 채우기
    private static void get_exist(){
        // 배열 초기화
        exist = new boolean[n][n];
        // 클라우드 리스트 기반으로 만드니까 거기있는거 돌면서 적기
        for(Cloud cloud : clouds){
            int x = cloud.x;
            int y = cloud.y;
            exist[x][y] = true;
        }
    }

    // exist배열 기반으로 cloud배열 채우기
    private static void get_cloud(){
        // cloud 리스트 초기화
        clouds = new ArrayList<>();
        // exist배열 돌면서 객체 저장
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                if(exist[i][j]){
                    clouds.add(new Cloud(i,j));
                }
            }
        }
    }
    public static void printCloudList(){
        for(Cloud cloud : clouds){
            System.out.println(cloud.x + " " + cloud.y);
        }
    }
}