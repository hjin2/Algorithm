import java.util.*;
class Solution {
    public static PriorityQueue<Integer> pq;

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        pq = new PriorityQueue<>(Collections.reverseOrder());


        int idx = 0;
        while(true){
            if(idx >= enemy.length){
                answer = idx;
                break;
            }


            if(n < enemy[idx]){ // 현재 병사 < 적의 수 : 무적권을 쓴다.
                if(k >= 1){
                    // 만약에 k가 남아있으면 이걸 쓴다.
                    if(pq.size() != 0){
                        int pqMax = pq.peek();
                        // pq에서 최댓값 > enemy[idx]이면 n + pq최댓값하고, n - enemy[idx] 하고, idx += 1, pq에서 (pq에서 최댓값) 삭제
                        if(pqMax > enemy[idx]){
                            pq.poll();
                            pq.offer(enemy[idx]);
                            n += pqMax;
                            n -= enemy[idx];
                            idx += 1;
                            k -= 1;
                        }
                        // pq에서 최댓값 == enemy[idx]이면 그냥 k를 쓴다, idx += 1
                        else if(pqMax <= enemy[idx]){
                            idx += 1;
                            k -= 1;
                           // pq.offer(pqMax);
                        }
                    }else{ // pq에 암것도 없으면 걍 까방권 씀
                        k -= 1;
                        idx += 1;
                    }
                }else{
                    // k가 안남아있으면 종료한다.
                    answer = idx;
                    break;
                }
            }else if(n >= enemy[idx]){ // 현재 병사 > 적의 수 : 병사에서 걍 적 빼면됨, 글고 뺸 수 기록하자
                // pq에 enemy[idx]를 넣는다.
                pq.offer(enemy[idx]);
                // 병사n명에서 enemy[idx]명을 뺀다
                n -= enemy[idx];
                // idx += 1을 한다.
                idx += 1;
            }
            // System.out.println("=============");
        }
        return answer;
    }
}