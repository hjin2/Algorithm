import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o){
        if(o.y == y){
            return x - o.x;
        }
        return y - o.y;
    }
}
public class Main {
    public static List<Point> points;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        points = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point point = new Point(y,x);
            points.add(point);
        }

        Collections.sort(points);

        int result = 0;
        for(Point p : points){
            Point p1 = new Point(p.y + b , p.x + a);
            Point p2 = new Point(p.y , p.x + a);
            Point p3 = new Point(p.y + b , p.x );

            if(find(p1) && find(p2) && find(p3)) result++;
        }

        System.out.println(result);

    }
    public static boolean find(Point point){
        int s = 0;
        int e = n;

        while(s + 1 < e){
            int mid = (s + e) / 2;
            Point current = points.get(mid);

            if(current.y < point.y || (point.y == current.y && point.x >= current.x)){
                s = mid;
            }else{
                e = mid;
            }

        }
        if(points.get(s).y == point.y && points.get(s).x == point.x) return true;

        return false;
    }
}