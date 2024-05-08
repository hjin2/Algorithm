import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();
            if(menu.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            }else if(menu.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            }else if(menu.equals("pop_front")){
                if(deque.size() == 0){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.pollFirst());
                }
            }else if(menu.equals("pop_back")){
                if(deque.size() == 0){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.pollLast());
                }
            }else if(menu.equals("size")){
                System.out.println(deque.size());
            }else if(menu.equals("empty")){
                if(deque.size() == 0){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(menu.equals("front")){
                if(deque.size() == 0){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.peekFirst());
                }
            }else if(menu.equals("back")){
                if(deque.size() == 0){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.peekLast());
                }
            }


        }
    }
}