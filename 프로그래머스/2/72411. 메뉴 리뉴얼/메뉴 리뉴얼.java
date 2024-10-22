import java.util.*;
class Solution {
    public static HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        String[] answer = null;
        map = new HashMap<>();

        // orders를 돌면서 각 알파벳을 선택한다.
        for(int j = 0 ;j < course.length ; j++){
            for(int i = 0 ; i < orders.length ; i++){
                char[] chars = orders[i].toCharArray();
                Arrays.sort(chars);
                String sortedStr = new String(chars);
                rec(sortedStr, 0, course[j], "", 0);   
            }
            
            if(!map.isEmpty()){
            List<Integer> list = new ArrayList<>(map.values());
            int max = Collections.max(list);
            
            if(max >= 2){
                for(String key : map.keySet()){
                    if(map.get(key) == max){
                        result.add(key);
                    }
                }
            }
           map.clear();
        }
        }
        
        Collections.sort(result);
        answer = result.toArray(new String[0]); 
        return answer;
    }
    
    public static void rec(String word, int depth, int cidx, String tmp, int idx){
        if(depth == cidx){
           // System.out.println(tmp);
            if(map.get(tmp) != null){
                map.put(tmp, map.get(tmp) + 1);
            }else{
                map.put(tmp, 1);
            }
            return;
        }
        for(int i = idx ; i < word.length() ; i++){
            rec(word, depth + 1, cidx, tmp + word.charAt(i), i + 1);
        }
        
    }
}