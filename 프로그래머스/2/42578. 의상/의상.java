import java.util.*;
class Solution {
    public static Map<String, Integer> clothesMap;
    public int solution(String[][] clothes) {
        int answer = 0;
        clothesMap = new HashMap<>();
        
        for(int i = 0 ; i < clothes.length ; i++){
            String name = clothes[i][0];
            String category = clothes[i][1];
            clothesMap.put(category, clothesMap.getOrDefault(category, 0) + 1);
        }
        
        // 키 값 돌면서 (value값 + 1)해서 곱하기
        int result = 1;
        for(String keyName : clothesMap.keySet()){
            result = result * ((clothesMap.get(keyName) + 1));
        }
        
        result -= 1;
        answer = result;
        
    
        return answer;
    }
}