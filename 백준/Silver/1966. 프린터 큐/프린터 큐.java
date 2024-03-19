import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<int[]> queue;
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        queue = new LinkedList<>();

        for(int tc = 0 ; tc < testcase ; tc++){
//            System.out.println("테스트케이스 " + tc + "번 =====================");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
//            System.out.println("n : " + n + "  m : " + m);
            queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                int important = Integer.parseInt(st.nextToken());
//                System.out.printf("%d, %d 저장 ...\n" , i, important);
                queue.add(new int[]{i,important});
            }

//            System.out.println("저장 완료");

            // n개가 있고 m번째 있는 원소가 몇번째 나올 것인가를 묻는 문제
            // 1. queue의 맨 앞에 있는 문서의 중요도를 확인한다
            int cnt = 1;
            while(true){
                if(queue.size() == 0) {
//                    System.out.println("queue가 비어서 끝났습니다");
                    break;
                }
//                System.out.println("큐의 가장 첫번째 원소 빼내서 확인합니다. ");
                int[] top = queue.peek();
                int topIdx = top[0];
                int topImportant = top[1];
//                System.out.printf("인덱스: %d  중요도 : %d\n", topIdx, topImportant);


                if(back()){ // 중요도 높은 문서가 하나라도 있으면
//                    System.out.println("중요도 높은 문서가 한개라도 있어서 맨 앞에꺼 빼서 뒤로 넣습니다.");
                    top = queue.poll();
                    queue.add(top);
                }else{ // 중요도 높은 문서가 한개도 없으면
                    // 우리가 찾는 target이면 정답을 출력
                    if(topIdx == m){
//                        System.out.printf("중요도 높은 문서가 없고, 우리가 찾던거라서 %d 출력하고 이번 tc 종료합니다.\n",cnt);
                        System.out.println(cnt);
                        break;
                    }else {
                        // 우리가 찾는 target이 아니면 아예 제거
//                        System.out.println("중요도 높은 문서가 없고, 우리가 찾던 번째가 아니기때문에 버려버립니다.");
                        queue.remove();
                        cnt++;
                    }
                }
            }

        }

    }

    private static boolean back() {
        // 큐를 한바퀴 돌면서 뒤에 나보다 큰 수가 있는지 확인
        Queue<int[]> queuetmp = new LinkedList<>();
        int queuesize = queue.size();
        int[] now = queue.poll(); // 맨 앞에 것을 뽑아서 저장하고
        boolean have = false;
        queuetmp.add(now); // 다시 맨 뒤에 저장
        for(int i = 0 ;  i < queuesize - 1 ; i++){
            int[] nxt = queue.poll();
            if(nxt[1] > now[1]){
                have = true;
                queuetmp.add(nxt);
                break;
            }else{
                queuetmp.add(nxt);
            }
        }
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            queuetmp.add(tmp);
        }
        queue = queuetmp;
        return have;
    }
}