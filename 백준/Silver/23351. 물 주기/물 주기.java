import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = k;
        }
        int day = 1;

        while(true){
            // 가장 작은 수가 있는 곳을 찾고 거기서 n개, 단 n개했을때 범위 나감에 주의
            int min = 101;
            int minIdx = -1;
            for(int i = 0 ; i < n; i++){
                if(min > arr[i]){
                    min = arr[i];
                    minIdx = i;
                }
            }

            if(minIdx + a >= n){
                int tmp = minIdx + a - n;
                minIdx -= tmp;
//                if(minIdx < 0){
//                    minIdx = 0;
//                }
            }

            int cnt = 0; // 물주는 개수 세기
            for(int i = minIdx ; i < n ; i++){
                if(cnt != a) { // minIdx 부터 a개 물을 줘야됨
                    arr[i] += b;
                    cnt++;
                }
            }


            // 여기까지가 랑이 집사가 연속된
            //A개의 화분에 물을 준다. 이 때 물을 준 화분의 수분은
            //B만큼씩 증가한다.

            for(int i = 0 ; i < n; i++){
                arr[i] -= 1;
            }


            // 여기까지 1씩 감소

            for(int i = 0 ; i < n; i++) {
                if (arr[i] == 0) {
                    System.out.print(day);
                    return; // 아예 끝내야하니까 return
                }
            }

            day += 1;
        }

    }
}