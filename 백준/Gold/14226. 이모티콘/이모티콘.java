import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Emoji{
    int clipboard;
    int total;
    int time;
    public Emoji(int clipboard, int total, int time){
        this.clipboard = clipboard;
        this.total = total;
        this.time = time;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        bfs(n);
    }
    public static void bfs(int n){
        boolean[][] visited = new boolean[2001][2001];
        Queue<Emoji> queue = new LinkedList<>();
        queue.add(new Emoji(0,1,0));
        visited[0][1] = true; // 복사된 개수 화면출력 임티

        while(!queue.isEmpty()){
            Emoji now = queue.poll();

            if(now.total == n){
                System.out.println(now.time);
                return;
            }


            queue.offer(new Emoji(now.total, now.total, now.time + 1));

            if(now.clipboard != 0 && now.total + now.clipboard <= n && !visited[now.clipboard][now.total + now.clipboard]){
                queue.offer(new Emoji(now.clipboard, now.total + now.clipboard, now.time + 1));
                visited[now.clipboard][now.total + now.clipboard] = true;
            }
            
      
            if(now.total >= 1 && !visited[now.clipboard][now.total - 1]){
                queue.offer(new Emoji(now.clipboard, now.total - 1, now.time + 1));
                visited[now.clipboard][now.total - 1] = true;
            }
        }

    }
}