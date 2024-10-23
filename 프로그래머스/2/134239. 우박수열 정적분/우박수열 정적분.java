import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = null;
        List<int[]> dots = new ArrayList<>();
        // 1. n 값 찾기
        // 2. 각 좌표 찾기 - (x,y)좌표들 여러개를 어떻게 저장할것인가?
        //                 (0, k) 좌표 미리 추가해두기
        // 3. 넓이 찾기
        
        dots.add(new int[]{0,k});
        int n = 1;
        while(k > 1){
            if(k % 2 == 0){
                k = k / 2;
                dots.add(new int[]{n,k});
            }else if(k % 2 == 1){
                k = k * 3 + 1;
                dots.add(new int[]{n,k});
            }
            n++;
        }
        n = n - 1;  // 몇 회 하는거니까!!!!!!!!! 내가 첨에 n=1을 한거는 좌표 저장하려고 한거고
        // 횟수는 0부터 시작하도록 해야된다
        
        // 여기선 n = k
        // 넓이찾기
        // 기존의 넓이를 구해놓기 
        double[] width = new double[dots.size() - 1];
        for(int i = 0 ; i < dots.size() - 1 ; i++){
            double tmp = (dots.get(i)[1] + dots.get(i + 1)[1]) / 2.0;
            width[i] = tmp;
        }
        List<Double> result = new ArrayList<>();
        // 입력받은 것의 넓이 구하기
        
        for(int i = 0 ; i < ranges.length ; i++){
            if(ranges[i][0] == 0 && ranges[i][1] == 0){
                double total = 0;
                for(int h = 0 ; h < width.length ; h++){
                    total += width[h];
                }
                result.add(total);
            }else{

            int x1 = ranges[i][0];
            int x2 = ranges[i][1];
         
            x2 = (n - Math.abs(x2));
                  if(x1 > x2){
                    result.add(-1.0);
                    continue;
                }
            double total = 0;
            for(int x = x1 ; x < x2 ; x++){
                total += width[x];
            }
            result.add(total);
            }
        }
        
        answer = result.stream().mapToDouble(Double::doubleValue).toArray();

        
        return answer;
    }
}