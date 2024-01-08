import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] sosus = new boolean[1001];
        for(int i = 0 ; i < 1001 ; i++){
            sosus[i] = true;
        }
        era(sosus);


        int cnt = 0;
        for(int i = 0 ; i < n; i++){
            int num = sc.nextInt();
            if(sosus[num])
                cnt++;
        }
        System.out.println(cnt);

    }
    public static void era(boolean[] sosus){
        // 소수구할때 에라모르겠다 체
        // 1. 모든 수는 소수이다
        // 2. 1은 소수가 아니다
        sosus[1] = false;
        for(int i = 2 ; i <= Math.sqrt(1001) ; i++){
            if(!sosus[i]){
                continue;
            }
            for(int j = i*i ; j < 1001 ; j++){
                if(j % i == 0) { // 소수로 나누어지는 애들 다 제거해~!
                    sosus[j] = false; // sosus[j] j!!!!!!!!
                }
            }
        }
    }
}