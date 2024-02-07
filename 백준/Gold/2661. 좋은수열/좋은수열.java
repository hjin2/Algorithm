import java.util.Scanner;

public class Main {
    static int start = 1;
    static int end = 3;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        rec("");
    }

    public static void rec(String str){
        if(str.length() == n){
            System.out.println(str);
            System.exit(0);
        }

        for(int i = 1 ; i <= 3 ; i++){
            if(can_make_str(str + i)){
                rec(str + i);
            }
        }
    }
    public static boolean can_make_str(String str){
        for(int i = 1 ; i <= str.length() / 2 ; i++){
            String back = str.substring(str.length() - i, str.length());
            String front = str.substring(str.length() - i * 2 , str.length() - i);
            if(front.equals(back)) return false;
        }
        return true;
    }
}