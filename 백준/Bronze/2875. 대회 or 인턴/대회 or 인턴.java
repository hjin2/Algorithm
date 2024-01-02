import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int all = n + m;

        int team = 0;
        while(n>=2 && m>=1){
            n -= 2;
            m -= 1;
            team++;
        }


        if(all - ( 3 * team) >= k){ // 팀을 최대로 결성하고 남은애들이 k보다 같거나 크면
            System.out.println(team); // 그 팀은 다 나갈 수 있다

        }else{ // 남은애들로 어학연수 못보내면 팀을 해체시켜야해
            // 몇 팀을 해체시켜야 하는가?

            k = k - (all - ( 3 * team)); // 일단 남은애는 다 보내고
//            System.out.println(" k : " + k);
            // 그 다음에 남은 애를 보고 몇 팀을 해체할 것인가
            if(k % 3 == 0){
                team -= k / 3;
            }else{
                team = team - (k / 3 + 1);
            }
            System.out.println(team);
        }

    }
}