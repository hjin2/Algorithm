import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        rec("");
    }
    public static void rec(String str){
        if(str.length() == N){
            System.out.println(str);
            System.exit(0);
        }
        
        for(int i = 1 ; i <= 3 ; i++){
            if(goodnum(str + i)){
                rec(str + i);
            }
        }
    }
    
    public static boolean goodnum(String str){
        for(int i = 1 ; i <= str.length() / 2 ; i++){
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if(front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}