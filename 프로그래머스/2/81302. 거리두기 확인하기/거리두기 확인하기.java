import java.util.*;
class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public boolean[][] visited = new boolean[5][5];

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0 ; i < 5 ; i++){
            boolean possible = true;
            
            for(int x = 0 ; x < 5 ; x++){
                for(int y = 0 ; y < 5 ; y++){
                    visited = new boolean[5][5];
                    if(places[i][x].charAt(y)=='P'){
                        boolean tmp = bfs(i,x,y,places,visited);
                        System.out.println("i : " + i + "   x : " + x + "  y : " + y + "  tmp : " + tmp);
                        if(!tmp){
                            possible = false;

                        }
                    }
                }
            }
            if(possible){
            answer[i] = 1;
                }else{
                answer[i] = 0;
            }
        }
        return answer;
    }
    public boolean bfs(int i, int x, int y, String[][] places, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,x,y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int room = now[0];
            int nowX = now[1];
            int nowY = now[2];


            for(int r = 0 ; r < 4 ; r++){
                int nx = nowX + dx[r];
                int ny = nowY + dy[r];

                
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                
                if(visited[nx][ny]) continue;
                
                if(Math.abs(x - nx) + Math.abs(y - ny) > 2) continue;
                
                 if(places[room][nx].charAt(ny) == 'X'){
                    continue;
                }  
                
                if(Math.abs(x - nx) + Math.abs(y - ny) == 2 && places[room][nx].charAt(ny) == 'O'){
                    continue;
                }  
       
                
                if(places[room][nx].charAt(ny) == 'O'){
                    queue.add(new int[]{room,nx,ny});
                    visited[nx][ny] = true;
                }
                
                 if(Math.abs(x - nx) + Math.abs(y - ny) == 1 && places[room][nx].charAt(ny) =='P'){
                    return false;
                }
                
                if(Math.abs(x - nx) + Math.abs(y - ny) == 2 && places[room][nx].charAt(ny) =='P'){
                    return false;
                }
            }
            
        }
        
        return true;
    }
}

