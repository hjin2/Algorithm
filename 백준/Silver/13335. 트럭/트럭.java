import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<Integer> queue = new LinkedList<>();
    public static int[] trucks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 다리 건너는 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        st = new StringTokenizer(br.readLine());

        trucks = new int[n];
        for(int i = 0 ; i < n ; i++){
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int time = 0;
        for(int i = 0 ; i < trucks.length ; i++){
            int truck = trucks[i];

            while(true){
                // 큐가 비어있는 경우 -> 다리 위에 트럭이 없다
                if(queue.isEmpty()){
                    queue.add(truck); // 트럭올라가고
                    sum += truck;
                    time++; // 다리 오를 때 시간 추가
                    break;
                }else if(queue.size() == w){ // 거리에 트럭이 올라갈 수 있는 만큼 다 올라갔을 때
                    sum -= queue.poll(); // 큐에서 맨 앞에꺼 빼기
                }else{ // 다리 길이만큼 트럭이 없을 때
                    if(sum + truck <= l){
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else{
                        // 차 한개 더 올릴라했는데 크기가 넘어가면
                        queue.add(0);
                        time++;
                    }

                }
            }
        }
        System.out.println(time + w);

    }
}