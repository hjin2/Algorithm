import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long[] arr = new long[1000001]; // long과 Long뭔차이냐 진짜 기본기 에바야
    public static int a,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int q = Integer.parseInt(br.readLine());


        for(int tc = 0 ; tc < q ; tc++){
            st = new StringTokenizer(br.readLine());
            int fun = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // r까지의 합  - (l-1)까지의 합
            if(fun == 1){
                System.out.println(recursive(r,a,d) - recursive(l-1,a,d));
            }

            if(fun == 2){
                long min = a + ( l - 1 ) * d;
                long result = 1;
                for(int i = 1 ; i <= min ; i++){
                    boolean possible = true;
                    for(int j = l ; j <= r ; j++){
                        if( (a + (j-1) * d ) % i != 0){ // 연산자 우선순위를 생활화하자..하;;
                            possible = false;
                            break;
                        }
                    }
                    if(possible){
                        result = result < i ? i : result;
                    }
                }
                System.out.println(result);

            }
        }
    }

    private static long recursive(int r, int a, int d) { // r번째 까지의 누적합을 반환하는 함수
        if(r== 0){
            return arr[0] = 0;
        }
        if(r == 1){
            return arr[1] = a;
        }else if( r == 2){
            return arr[2] = a + (long) a + (r   - 1) * d;
        }

        if(arr[r] != 0){
            return arr[r];
        }

        return arr[r] = recursive(r-1, a, d) + (a + (r-1) * d); // r-1번째까지의 누적합 + r번째 원소
    }
}