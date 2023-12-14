import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;


        int girl = n / 2;
        if(m >= girl){
            result = girl;
        }else{
            result = m;
        }


        girl = n - 2*result;
        int boy = m - result;



        if(girl+boy < k){
            k = k - (girl+boy);
            if(k%3==0){
                result -= (k/3);
            }else{
                result -= (k/3) + 1;
            }
        }

        System.out.println(result);
    }
}