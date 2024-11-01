class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n + 1][n + 1];
        
        for(int i = 0 ; i < results.length ; i++){
            for(int j = 0 ; j < results[i].length ; j++){
                arr[results[i][0]][results[i][1]]++;
            }
        }
        
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1; j <= n ; j++){
                    if(arr[i][j] == 0 &&
                       arr[i][k] == 1 &&
                       arr[k][j] == 1){
                        arr[i][j] = 1;
                    }
                }
            }
        }
        

        int[] columnSum = new int[n];
        int[] rowSum = new int[n];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                columnSum[column] += arr[row][column];
                rowSum[row] += arr[row][column];
            }
        }
        

        for (int index = 0; index < n; index++) {
            if (columnSum[index] + rowSum[index] == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}