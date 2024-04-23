import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{1,Integer.parseInt(st.nextToken())}); // 처음에 나오는건 무조건 0이니까
        System.out.print("0 ");

        for(int i = 2; i <= n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {               // 스택이 비지않을때까지 계속 확인
                if (stack.peek()[1] >= tmp) {       // peek()은 최근에 추가된 데이터 조회!
                    // 거기 레이저를 쏠 수 있다.
                    System.out.print(stack.peek()[0] + " ");
                    
                    break;                          // 나보다 큰 곳을 찾으면 반복문 멈추기
                } else {
                    stack.pop(); // 거기에 레이저를 못쏘니까 제거, pop은 최근 추가된 데이터 제거!
                }
            }
            if(stack.empty()){
                System.out.print("0 ");
            }
            stack.push(new int[]{i,tmp});
        }
    }
}