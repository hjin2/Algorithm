import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static StringBuilder sb;
    static int N, K;
    static int cnt; // cnt번째
    static List<Integer> selected;
    static boolean possible = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        selected = new ArrayList<>();

        N = sc.nextInt(); // 1,2,3합쳐서 N이 되어야함
        K = sc.nextInt(); // K번째 오는 수는?

        rec(0);
        if(!possible)
            System.out.println(-1);
    }
    public static void rec(int sum){
        if(sum == N){ // 합쳐서 K가 됐을때
            cnt++;
            if(cnt == K){
                // 이때까지 선택한 숫자들 출력
                possible = true;
                for(int i = 0 ; i < selected.size() ; i++){
                    System.out.print(selected.get(i));
                    if(i != selected.size() - 1) {
                        System.out.print("+");
                    }
                }
            }
            return;
        }
        if(sum > N){ // 넘어가는 순간 아무리 더해봤자 K가 안되니까 돌아가기
            return;
        }
        for(int i = 1 ; i <= 3; i++){
            sum += i;
            selected.add(i);
            rec(sum);
            sum -= selected.get(selected.size() - 1);
            selected.remove(selected.size() - 1);
        }
    }
}