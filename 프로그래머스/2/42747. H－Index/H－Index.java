import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] arr = new int[10001];
        
        for(int i = 0 ; i < citations.length ; i++){
            arr[citations[i]]++;
        }
        int total = 0;
        for(int i = 0 ; i < arr.length ; i++){
            total += arr[i];
        }
        System.out.println("to : " + total);

        for(int i = 10000 ; i >= 0 ; i--){
            int tmp = 0;
            for(int j = i ; j <= 10000 ; j++){
                tmp += arr[j];
            }
            int h = i;
            if(h <= tmp && ((total - tmp) <= h)){
                answer = Math.max(h, answer);
            }
        }
        return answer;
    }
}