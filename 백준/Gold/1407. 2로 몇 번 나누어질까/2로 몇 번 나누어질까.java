import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(func(b) - func(a-1));

    }

    public static long func(long num){
        long answer = 0;
        long tmp = 1;
        while(num != 0){
            if(num % 2 != 0){
                answer = answer + ((num / 2) + 1) * tmp;
            }else{
                answer = answer + (num / 2) * tmp;
            }
            tmp = tmp * 2;
            num = num / 2;
        }
        return answer;
    }
}