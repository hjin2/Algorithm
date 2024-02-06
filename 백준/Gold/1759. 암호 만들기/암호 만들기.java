import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L, C;
    static char[] characters;
    static char[] selected;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        L = sc.nextInt();
        C = sc.nextInt();
        characters = new char[C];
        selected = new char[L];

        for(int i = 0 ; i < C ; i++){
            characters[i] = sc.next().charAt(0);
        }

        Arrays.sort(characters);

        comb(0,0);
        System.out.println(sb);
    }
    public static void comb(int depth, int startidx){
        if(depth == L){ // L개를 다 뽑았을때
            // 비밀번호의 조건에 맞는지 확인하기
            int consonant = 0;
            for(int i = 0 ; i < L ; i++){
                if(selected[i] == 'a' || selected[i] == 'e' || selected[i] == 'i' || selected[i] == 'o' || selected[i] == 'u'){
                    consonant++;
                }
            }
            if(consonant >= 1 && (L - consonant) >= 2){
                for(int i = 0 ; i < L ; i++){
                    sb.append(selected[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i = startidx ; i < C ; i++){
            selected[depth] = characters[i];
            comb(depth + 1, i + 1);
        }
    }
}