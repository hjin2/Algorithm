class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n + 1][n + 1];
        
        for(int i = 0 ; i < results.length ; i++){
            arr[results[i][0]][results[i][1]]++;
        }


        /* 출력합니다.
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        */
        
        
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(arr[i][j] == 0 &&
                      arr[i][k] == 1 &&
                      arr[k][j] == 1){
                        arr[i][j] = 1;
                    }
                }
            }
        }
        
       
        for(int i = 1 ; i <= n ; i++){
            int cnt = 0;
            for(int j = 1 ; j <= n ; j++){
                if(arr[i][j] == 1 || arr[j][i] == 1){
                    cnt++;
                }
            }
            if(cnt == n - 1){
                answer++;
            }
        }
        
        return answer;
    }
}