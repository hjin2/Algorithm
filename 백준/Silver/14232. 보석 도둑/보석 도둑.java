import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());

        List<Long> list = new ArrayList<>();


        for(long i = 2 ; i <= Math.sqrt(n) ; i++){
//            System.out.println("i : " + i);
            while(n % i == 0){ // n이 i로 계속해서 나누어질 수 있을때까지 계속 나눈다.
//                System.out.print(i + " ");
                list.add(i);
                n /= i;
//                if(n == 1) break; // n==1
            } // 더이상 나누지 못해서 나간다
        }
        if(n!=1) {
            list.add(n);
        }

        System.out.println(list.size());
        for(int i = 0 ; i < list.size() ; i++){
            System.out.print(list.get(i) + " ");

        }


    }
}