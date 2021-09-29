package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1753_최단경로_Solution {
	static int V, E;
	static LinkedList<Edge>[]adj;
	static int[] distance;
	static boolean[] used; // 경유지가 된적이 있는지
	static int start;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new LinkedList[V+1]; // 모든 정점들이 인접 정보를 저장할 각각의 리스트
		
		for(int v=0; v<=V; v++) {
			adj[v] = new LinkedList<>();
		}
		start = Integer.parseInt(br.readLine());
		
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v, w));
		}
		
		dijkstra();
		
		StringBuilder sb= new StringBuilder();
		for(int v=1; v<=V; v++) {
			sb.append(distance[v]==Integer.MAX_VALUE?"INF":distance[v]).append("\n");
		}
		System.out.println(sb.toString());		
	}

	static void dijkstra() {
		distance = new int[V+1];
		used = new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for(int i=0; i<V; i++) { // V개의 정점이 모두 경유지가 되어야 모든 정점까지 최단이 나옴.
			int min = Integer.MAX_VALUE;
			int curr = 0;
			
			for(int d=1; d<=V; d++) { 
				if(min > distance[d] && !used[d]) { // distance 최소(가까운)중 경유지 된적 없는애
					min = distance[d];
					curr = d;
				}
			} // 경유지 찾기 완료
			
//			for(int e=0; e<adj[curr].size(); e++) {
//				Edge edge = adj[curr].get(e);
			for(Edge edge : adj[curr]) {
				if(distance[edge.num] > distance[curr]+edge.dist) {
					distance[edge.num] = distance[curr]+edge.dist;
				}
			}
			used[curr] = true;
		}
	}
	
	static class Edge{
		int num, dist; // 이 간선을 따라가면 도착하는 정점과 그 간선의 길이
		
		Edge(int n, int d){
			num = n;
			dist = d;
		}
	}
}
