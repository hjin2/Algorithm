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
            } // 더이상 나누지 못해서 나간다
        }
        if(n!=1) { // 왜 이걸해주냐? n= 277일때, 소인수는 1과 277이다. i에서 2부터 16까지밖에 안가기때문에 이걸해준다. 그치만 더 쉬운 방법이 생각나버렸다
            list.add(n);
        } // 쉬운방법은 굳이 이걸안하고 i를 1부터한다음 출력할때 1을 빼주면 되는것이다 근데 ? 그러면 계에에속 반복문을 돌기때문에 쉬운방법이라 생각난건 사실 틀린거였다.. 걍 이렇게 ㄱ

        System.out.println(list.size());
        for(int i = 0 ; i < list.size() ; i++){
            System.out.print(list.get(i) + " ");

        }


    }
}