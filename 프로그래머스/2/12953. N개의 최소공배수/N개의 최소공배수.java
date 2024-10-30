class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int result = 0;
        if(arr.length == 1){
            answer = arr[0];
            return answer;
        }else if(arr.length == 2){
            answer = arr[0] * arr[1] / gcd(arr[0], arr[1]);
            return answer;
        }else{
            result = arr[0] * arr[1] / gcd(arr[0], arr[1]);
            for(int i = 2 ; i < arr.length ; i++){
                // lcm(a,b) = a * b / gcd(a,b)
                result = arr[i] * result / gcd(arr[i], result); 
            }
            answer = result;
        }
        return answer;
    }
    public static int gcd(int a, int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}