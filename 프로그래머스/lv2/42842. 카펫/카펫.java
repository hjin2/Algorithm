import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] answer = {1,2};
        int big = 0;
        if(brown<yellow){
            big = yellow;
        }else{
            big = brown;
        }
        List<Integer> sero = new ArrayList<>();
        // 1부터 sum/2 까지 돌면서 확인
        for(int i = 1; i <= sum/2 ; i++){
            if(sum%i==0){
                sero.add(i);
            }
        }
        // 가+가+세+세-4 = 큰 수?
        for(int i = 0 ; i < sero.size() ;i++){
            int g = sum / sero.get(i);
            int s = sero.get(i);
            if((g-2)*(s-2)==yellow){
                answer[1] = g;
                answer[0] = s;
            }
        }

        return answer;
    }
}