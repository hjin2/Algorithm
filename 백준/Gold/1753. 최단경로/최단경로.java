import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	int weight;
	
	Node(int end, int weight){
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}

	
public class Main {
	static int v, e,startPos;
	static ArrayList<ArrayList<Node>> a; 
	static boolean[] visited;
	static int[] dist; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		startPos = Integer.parseInt(br.readLine());
		a = new ArrayList<>();
		for(int i = 0 ; i < v+1 ; i++) {
			a.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			a.get(start).add(new Node(end,weight));
		}
		
		
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
//		for(int n : dijkstra(startPos)) {
//			System.out.println(n);
//			
//		}
		int[] finaldist = dijkstra(startPos);
		
		for(int i = 1 ; i < dist.length ;i++) {
			if(finaldist[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(finaldist[i]);
		}
		
	
	}
	
	public static int[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[v+1];
		pq.add(new Node(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			
			if(!visited[cur]) {
				visited[cur] = true;
				for(Node node : a.get(cur)) {
					if(!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
			
		}
		
		
		return dist;
	}
}
