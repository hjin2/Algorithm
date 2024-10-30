import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for(int i = 1 ; i <= elements.length ; i++){ // 배열 전체 길이도 포함!
            for(int j = 0 ; j < elements.length ; j++){
                int num = 0;
                for(int k = j ; k < j + i ; k++){
                    num += elements[ k % elements.length];
                }
                set.add(num);
            }
            
        }
        answer = set.size();
        return answer;
    }
}