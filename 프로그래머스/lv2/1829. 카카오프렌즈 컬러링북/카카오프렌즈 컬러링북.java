class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public static int tmp = 0;
    public boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(picture[i][j]>0 && !visited[i][j]){
                    tmp=0;
                    dfs(i,j,picture,m,n,picture[i][j]);
                    maxSizeOfOneArea = tmp > maxSizeOfOneArea ? tmp : maxSizeOfOneArea; 
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    
    public void dfs(int x,int y, int[][] picture, int m, int n, int gijun){
        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx>=0 && ny>=0 && nx<m && ny<n){
                if(!visited[nx][ny]){
                if(picture[nx][ny]>0 && picture[nx][ny]==gijun){
                    visited[nx][ny]=true;
                    tmp++;
                    dfs(nx,ny,picture,m,n,gijun);
                    }
                }
            }
            
        }
    }
}