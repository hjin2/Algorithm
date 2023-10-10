import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0 ; i < tangerine.length ; i++){
            if(map.get(tangerine[i])==null){
                map.put(tangerine[i],1);
            }else{
                map.replace(tangerine[i],map.get(tangerine[i])+1);
            }
        }
        List<Integer> keySet = new ArrayList<>(map.values());
        // keySet.sort((o1,o2)->map.get(o2).compareTo(map.get(o1)));
        Collections.sort(keySet,Comparator.reverseOrder());
        for(int i = 0 ; i < keySet.size() ; i++){
            // System.out.println(" 리스트 i : " + i + " 리스트 내부 값 : " + keySet.get(i));
        }
        int cnt=0;
        int keyCnt = 0;
        for(Integer num : keySet){
            // System.out.println("num : " + num  + "  map.get(num) : " + map.get(num));
            if(cnt >= k){
                // System.out.print("끝이 났읍니다.");
                return keyCnt;
            }
            cnt += num;
            keyCnt+=1;
        }
        return keyCnt;
    }
}