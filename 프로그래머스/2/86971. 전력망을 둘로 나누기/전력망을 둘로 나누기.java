import java.util.*;
class Solution {
    public static int sidcnt = 0;
    public static int total = 0;
    public static int result = Integer.MAX_VALUE;
    public static boolean[] visited = new boolean[101];
    public static List<ArrayList<Integer>> graph;
    public int solution(int n, int[][] wires) {
        int answer = -1;
    
        graph = new ArrayList<>();
        for(int i = 0 ; i < 101 ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < wires.length ; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        for(int i = 0 ; i < 101 ; i++){
            if(graph.get(i).size() != 0 ){
                total += 1;
            }
        }
        
        for(int i = 0 ; i < 101 ; i++){
            for(int j = 0 ; j < graph.get(i).size() ; j++){
                visited[i] = true;
                visited[graph.get(i).get(j)] = true;
               
                dfs(graph.get(i).get(j));
                
     
                

                int left = total - (sidcnt + 1);
                int right = sidcnt + 1;
                int tmp = Math.abs(left-right);
                result = tmp < result ? tmp : result;
                
                sidcnt = 0;
                visited = new boolean[101];
            }
        }
        answer = result;
        return answer;
    }
    public static void dfs(int j){
        for(int i = 0 ; i < graph.get(j).size(); i++){
            if(visited[graph.get(j).get(i)]) continue;
            visited[graph.get(j).get(i)] = true;
            sidcnt +=1;
            dfs(graph.get(j).get(i));
        }
    }
}