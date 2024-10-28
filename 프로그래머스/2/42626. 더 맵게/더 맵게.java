import java.util.*;
class Solution {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int k) {
        int answer = 0;
        
        for(int i = 0 ; i < scoville.length ; i++){
            pq.offer(scoville[i]);
        }
        
        while(pq.peek() < k){
            if(pq.size() == 1){
                answer = -1;
                break;
            }
            int newFood = pq.poll() + pq.poll() * 2;
            answer++;
            pq.offer(newFood);
        }
        
    
             
        return answer;
    }
}