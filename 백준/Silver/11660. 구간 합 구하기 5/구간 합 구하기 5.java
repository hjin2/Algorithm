import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int[][] narr = new int[n][n];

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;                    // 행별로 누적합을 구할 변수
            for(int j = 0 ; j < n; j++){
                if(j==0){                   // 0번째 열에서는 무조건 그냥 자기자신
                    narr[i][j] = Integer.parseInt(st.nextToken());
                    sum+=narr[i][j];        // sum업데이트
                }
                else {
                    narr[i][j] = sum + Integer.parseInt(st.nextToken());   // 0번째 아닐때는 누적합에 원래 내 배열에 있는 값 더하기
                    sum = narr[i][j];   // 행별 누적합을 업데이트 해줘야한다
                }
            }
        }



//        for(int i = 0 ; i < n; i++){
//            for(int j = 0 ; j < n; j++){
//                System.out.print(narr[i][j] + " ");
//            }
//            System.out.println();
//        }


        for(int i = 0 ; i < cnt ; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            for(int x = (x1-1) ; x <x2 ; x++){
                if(y2-1>=0 && y1-2>=0)
                    sum = sum + (narr[x][y2-1] - narr[x][y1-2]);
//                System.out.println(sum);
                else
                    sum = sum + (narr[x][y2-1]);

            }

            sb.append(sum + "\n");

            // 저장할 때 한칸씩 움직이면서 배열에 저장하기

        }
        System.out.println(sb);
    }
}