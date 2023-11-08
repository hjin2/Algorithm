class Solution {
    public static int[] parent;
    public static boolean[] visitedNum;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0 ; i < n; i++){
            parent[i] = i;
        }

        
        visitedNum = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                union(i,j,computers,n);
            }
        }
        for(int i = 0 ; i < n; i++){
            System.out.print(parent[i] + " " );
        }
        
        
        for(int i = 0 ; i < n; i++){ 
            visitedNum[parent[i]] = true;
        }
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(visitedNum[i]){
                cnt++;
            }
        }
        return cnt;
    }
    
    public static void union(int a, int b, int[][] computers, int n){
        boolean flag = false;
        for(int i = 0 ; i < n ; i++){
            if(computers[a][i] == 1 && computers[b][i] == 1){
                parent[b] = find(parent[i]);
                flag = true;
            }
        }
        if(!flag){
            parent[b] = b;
        }
    }
    
    public static int find(int n){
        if(parent[n] == n){
            return n;
        }
        return parent[n] = find(parent[n]);
    }
    
}