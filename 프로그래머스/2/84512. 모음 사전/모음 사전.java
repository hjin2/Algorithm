class Solution {
    public static String[] alpha = {"A","E","I","O","U"};
    public static int cnt;
    public static int result;
    public int solution(String word) {
        for(int i = 0 ; i < 5; i++){
        dfs(0,alpha[i],word);
        }
        return result;
    }
    
        public static void dfs(int depth,String str, String word){
        if(depth == 5){

            return;
        }
        cnt++;
        if(str.equals(word)) {
            result = cnt;
        }
        for(int i = 0 ; i < alpha.length ; i++){
//            System.out.print(num + "  ");bp 0
            dfs(depth+1,str+alpha[i],word);

        }
    }
}