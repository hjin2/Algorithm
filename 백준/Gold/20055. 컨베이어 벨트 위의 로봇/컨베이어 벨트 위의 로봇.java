import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n,k;
    public static int[] belt;
    public static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[n * 2]; // 컨베이어 벨트는 아랫부분까지 있으니까
        robot = new boolean[n]; // 로봇은 윗쪽부분에만 있을 수 있음
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n * 2 ;  i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int turn = 0;
        while(k > 0){
            int tmp = belt[n * 2 - 1];
            for(int i = n * 2 - 1 ; i > 0 ; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = tmp;

            for(int i = n - 1; i > 0 ; i--){
                robot[i] = robot[i - 1];
            }

            robot[n-1] = false;
            robot[0] = false;


            for(int i = n - 1; i > 0 ; i--){
                if(!robot[i] && robot[i-1] && belt[i] > 0){
                    belt[i]--;
                    if(belt[i] == 0){
                        k--;
                    }
                    robot[i] = true;
                    robot[i-1] = false;
                }
            }

            if(belt[0] > 0){
                belt[0]--;
                if(belt[0] == 0){
                    k--;
                }
                robot[0] = true;
            }
            turn++;
        }
        System.out.println(turn);

    }
}