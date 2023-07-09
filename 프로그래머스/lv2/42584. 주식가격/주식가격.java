class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0 ; i < prices.length-1 ; i++){
            int up = 0;
            for(int j = i+1; j < prices.length ; j++){
                if(prices[i] <= prices[j]){
                    up++;
                }else{
                    if(up==0) 
                        up=1;
                    else
                        up+=1;
                    break;
                }
            }
             answer[i] = up;
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}