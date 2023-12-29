class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int cnt = 1;
        while(true){
            
            if(a < b && a % 2 == 1 && a+1 == b && b-1 == a){
                answer = cnt;
                break;
            }if( b < a && b % 2 == 1 && b+1 == a && a-1 == b){
                 answer = cnt;
                break;
            }
            
              if(a%2==1){
                    a = (a / 2) + 1;
                }else{
                    a = (a / 2);
                }

                if(b%2 == 1){
                    b = (b / 2) + 1;
                }else{
                    b = (b / 2);
                }

                cnt++;
                            
        }

        return answer;
    }
    
}
