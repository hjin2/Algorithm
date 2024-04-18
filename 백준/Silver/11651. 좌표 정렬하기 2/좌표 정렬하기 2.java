import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Dot implements Comparable<Dot>{
    int x;
    int y;
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Dot dot){
        if(this.y == dot.y){
            return this.x - dot.x;
        }
        return this.y - dot.y;
    }
}
public class Main {
    public static List<Dot> dots = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            dots.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(dots);
        for(Dot dot : dots){
            System.out.println(dot.x + " " + dot.y);
        }
    }
}