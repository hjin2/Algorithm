class Solution {
    public static int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = computers.length;
        parent = new int[n];
        for(int i = 0 ; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0 ; i < computers.length ;i++){
            for(int j = 0 ; j < computers[i].length ; j++){
                if(computers[i][j] == 1 && find(i) != find(j)){
                    // if(find(i) != find(j)){
                        union(i,j);
                        answer--;
                    // }
                }
            }
        }
        return answer;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
}