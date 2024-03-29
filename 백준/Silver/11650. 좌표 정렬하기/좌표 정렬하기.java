import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node node){
        if(this.x == node.x){
            return this.y - node.y;
        }
        return this.x - node.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for(int i = 0 ; i < n;  i++){
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes);
        for(int i = 0 ; i < n ; i++){
            System.out.println(nodes[i].x + " " + nodes[i].y);
        }
    }

}