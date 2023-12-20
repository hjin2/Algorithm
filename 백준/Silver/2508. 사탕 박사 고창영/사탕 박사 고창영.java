import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();


        while( t-- > 0){
//            sc.nextLine();
            int r = sc.nextInt();
            int c = sc.nextInt();
            int result = 0;
            char[][] arr = new char[r][c]; // 입력받을 때 자료형 잘보기

            for(int x = 0 ; x < r ; x++){
                String tmp = sc.next();     // 입력이 공백이나 엔터로 띄어져 있는게 아니다! 입력 형식 주의
                for(int y = 0 ; y < c ; y++){
                    arr[x][y] = tmp.charAt(y);
                }
            }


            // >o< 있는지 찾기
            for(int x = 0 ; x < r ; x++){
                for(int y = 0 ; y <= c - 3 ; y++){
                    if(arr[x][y] == '>' && arr[x][y+1] == 'o' && arr[x][y+2] == '<'){
                        result += 1;
                    }
                }
            }

            // >o< 있는지 찾기

            for(int y = 0 ; y < c ; y++){
                for(int x = 0 ; x <= r - 3 ; x++){
                    if((int)arr[x][y] == 118 && arr[x+1][y] == 'o' && arr[x+2][y] == '^'){
                        result += 1;
                    }
                }
            }

            System.out.println(result);
        }
    }
}