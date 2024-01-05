import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long num = Long.parseLong(br.readLine());

        if(num == 1){ // 1안해서 98퍼인듯
            System.out.println("no");
            return;
        }
        if(exist(num)){ // 3,4,7이 포함되어있는지 유무를 반환하는 함수
            System.out.println("no");
            return;
        }
        if(!sosu(num)){
            System.out.println("no");
            return;
        }
        if(!sosu(reverse(num))){
            System.out.println("no");
            return;
        }
        System.out.println("yes");

    }

    public static long reverse(long num){
        // 180돌 때 뒤에서부터 읽어야함, 그리고 6->9, 9->6임
        char[] nums = String.valueOf(num).toCharArray();
        char[] newnums = new char[nums.length];
        int numsLen = nums.length;
        for(int i = 0 ; i < numsLen ; i++){
            newnums[i] = nums[(numsLen-1)-i];
            if(newnums[i] == '6'){
                newnums[i] = '9';
            }else if(newnums[i] == '9'){
                newnums[i] = '6';
            }
        }
        // char[] 배열을 다시 string으로 어떻게하더라
        String reverse = String.valueOf(newnums);
        return Long.valueOf(reverse);
    }

    private static boolean sosu(Long num) {
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean exist(Long num) {
        String nums = String.valueOf(num);
        for(int i = 0 ; i < nums.length() ; i++){
            if(nums.charAt(i) == '3' || nums.charAt(i) == '4' ||nums.charAt(i) == '7'){
                return true;
            }
        }
        return false;
    }
}