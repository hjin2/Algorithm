// class Solution {
//     public static long answer;
//     public long solution(int n) {
//         answer = 0;
//         dfs(0,n);
//         // answer = answer % 1234567;
//         return answer;
//     }
    
//     public static void dfs(int sum, int n){
//         if(sum==n){
//             answer++;
//             return;
//         }
//         for(int i = 1 ; i <= 2; i++){
//             if(sum>n)
//                 break;
//             sum += i;
//             System.out.println("i : " + i);
//             dfs(sum,n);
//             // dfs끝나면 sum=0으로 만들어줘야함? 과연그럴까?
//             sum -=i;
//         }
//     }
// }

class Solution {
    public long solution(int n) {
        long arr []= new long[2001];

	    arr[1]=1;
	    arr[2]=2;
	 
	    for(int i=3; i<2001; i++) {
		    arr[i] = (arr[i-1]+arr[i-2])%1234567;			 
	    }		 
	        return arr[n];
        
    }
}