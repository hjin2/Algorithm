import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] change_time = new int[book_time.length][book_time[0].length];
        
        // 시간을 비교하기 위해 전부 분으로 바꾸귀
        for(int i = 0 ; i < book_time.length ; i++){
            for(int j = 0 ; j < book_time[i].length ; j++){
                String stime = book_time[i][j];
                int total = 0;
                int hour = Integer.parseInt(stime.substring(0,2)) * 60;
                int min = Integer.parseInt(stime.substring(3));
                total = hour + min;
                change_time[i][j] = total;
            }
        }
        
    
        
       // 1. 시작시간순으로 정렬한다.
        Arrays.sort(change_time, (x,y)-> {return x[0]- y[0];});

        // 2. count + 1
        answer += 1;
        
        // 3. 종료시간 배열
        List<Integer> end = new ArrayList<>();
        end.add((change_time[0][1] + 10));
        
        // 4. 두번째 예약부터 끝까지 돌면서
            // 종료시간 리스트를 돌면서 확인한다
        for(int i = 1 ; i < change_time.length ; i++){
            boolean have = false;
            int tmpidx = -1;
            for(int j = 0 ; j < end.size(); j++){
                if(end.get(j) <= change_time[i][0]){
                    tmpidx = j;
                    have = true;
                }
            }
            if(have){
                // 있으면 ㅇㅋ 그냥 넘어가기
                // 기존에 있던거 지우고, 새로 갱신하는 시간 종료시간으로 변경
                end.set(tmpidx, (change_time[i][1] + 10));
            }else{
                answer++;
                end.add((change_time[i][1] + 10));
            }
        }
        
        
        
        
        
        return answer;
    }
}