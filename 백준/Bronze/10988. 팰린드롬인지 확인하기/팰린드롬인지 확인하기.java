import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        int sidx = 0;
        int eidx = word.length() - 1;

        int answer = 1;
        while( sidx < eidx ){
            if(word.charAt(sidx) != word.charAt(eidx)){
                answer = 0;
                break;
            }else{
                sidx++;
                eidx--;
            }

        }
        System.out.println(answer);
    }
}
