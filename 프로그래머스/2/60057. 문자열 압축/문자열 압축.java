import java.lang.*;
class Solution {
    public static String before ="";
    public static int answer = Integer.MAX_VALUE;
    public static int rest;
    public static int total;
    public int solution(String s){
        if(s.length()==1){
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length() ; i++){
            boolean possible = false;
            int totalNumbercnt = 0;
            int totalStringcnt = 0;
            int cnt = 0;
            String s1 = "";
            String tmp = "";
            // System.out.println("====" + i);

            for(int j = 0 ; j < s.length()-i+1 ;j=j+i){
                tmp = s.substring(j,j+i);
                if(before.equals(tmp)){ // 그 전 값이랑 같으면
                    cnt += 1;
                }else{ // 그 전 값이랑 다르면
                    if(cnt>1){
                    sb.append(cnt);
                    }
                    sb.append(s1);
                    cnt = 1;
                    s1 = tmp;
                }
                // System.out.println("tmp : " + tmp);
                total += tmp.length(); // 총 길이 어디까지 한거임? 전체에서 이거빼얗ㅎ함
                before = tmp;
            }
            if(cnt==1){
                sb.append(tmp);
            }else if(cnt>1){
                sb.append(cnt);
                sb.append(tmp);
            }
            // System.out.println("한 텀 돌고 최종 sb : " + sb);
            int rest = s.length()-total;
            // 여기서 sb의 길이 구하고 가장 짧은걸 택하기
            int len = sb.length() + rest;
            answer = answer > len ? len : answer;
            sb.setLength(0);
            // System.out.println("길이 : " + answer);
            total = 0;

        }
        return answer;
    }
}