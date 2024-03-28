import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        while(tc-- > 0){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if(type.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.add(num);
            }else if(type.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }else if(type.equals("size")){
                System.out.println(stack.size());
            }else if(type.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(type.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            }
        }
    }
}