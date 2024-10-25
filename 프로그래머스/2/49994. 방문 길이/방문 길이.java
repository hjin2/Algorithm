import java.util.*;
class Dot{
    int startX;
    int startY;
    int endX;
    int endY;
    public Dot(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
class Solution {
    // 상하좌우
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public int solution(String dirs) {
        int answer = 0;
        List<Dot> dots = new ArrayList<>();
        
        int beforeX = 0;
        int beforeY = 0;
        int afterX = 0;
        int afterY = 0;        
        
        for(int i = 0 ; i < dirs.length() ; i++){
            if(dirs.charAt(i) == 'U'){
                afterX = beforeX + dx[0];
                afterY = beforeY + dy[0];
            }else if(dirs.charAt(i) == 'D'){
                afterX = beforeX + dx[1];
                afterY = beforeY + dy[1];
            }else if(dirs.charAt(i) == 'L'){
                afterX = beforeX + dx[2];
                afterY = beforeY + dy[2];
            }else if(dirs.charAt(i) == 'R'){
                afterX = beforeX + dx[3];
                afterY = beforeY + dy[3];
            }
            
            if(afterX < -5 || afterX > 5 || afterY < -5 || afterY > 5){
                continue;
            }
            
            Dot now = new Dot(beforeX, beforeY, afterX, afterY);
            boolean same = false;
            for(int i2 = 0 ; i2 < dots.size() ; i2++){
                if((dots.get(i2).startX == beforeX &&
                  dots.get(i2).startY == beforeY &&
                  dots.get(i2).endX == afterX &&
                  dots.get(i2).endY == afterY) ||
                    (dots.get(i2).startX == afterX &&
                  dots.get(i2).startY == afterY &&
                  dots.get(i2).endX == beforeX &&
                  dots.get(i2).endY == beforeY)){
                    same = true;
                }
            }
            if(!same){
                answer += 1;
                dots.add(now);
            }
            
            beforeX = afterX;
            beforeY = afterY;
        }
        
        
        
        return answer;
    }
}