package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1753_최단경로_시간초과 {

	static int V;
	static int start;
	static final int INFINITY = Integer.MAX_VALUE;
	static Edge[] edgelist;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		
		Edge[] edgelist = new Edge[E];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			edgelist[i]=new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		//입력 끝
		for(int i=1;i<=V;i++) {
			dijkstra(i);
		}
		System.out.println(sb);
		
//		for(int i=1;i<=V;i++) {
//			int[] distance = new int[V+1];
//			boolean[] visited = new boolean[V+1];
//			Arrays.fill(distance, INFINITY);
//			distance[start] =0;
//			int min=0,current = 0;
//			int end =i;
//			for(int k=1;k<=V;k++) {
//				//1.방문하지 않은 정점들 중 최소가중치의 정점 선택
//				min = INFINITY;
//				for(int j=1;j<=V;j++) {
//					if(!visited[j] && distance[j]<min) {
//						min = distance[j];
//						current = j;
//					}
//				}
//				visited[current]=true;
//				if(current == end) {
//					break;
//				}
//				//2.current정점을 경유지로 해서 갈 수 있는 다른 방문하지 않은 정점들에 대한 처리
//				for(Edge edge : edgelist) {
//					if(edge.from==current && !visited[edge.to] && distance[edge.to]> min+edge.weight){
//						distance[edge.to] = min+edge.weight;
//					}
//				}
//			}
//			if(distance[end]>(V-1)*10) {
//				sb.append("INF\n");
//			}else {
//				sb.append(distance[end]+"\n");				
//			}
//		}
//		System.out.println(sb);
	}

	static class Edge {
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		
	}
	
	static void dijkstra(int i) {
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(distance, INFINITY);
		distance[start] =0;
		int min=0,current = 0;
		int end =i;
		for(int k=1;k<=V;k++) {
			//1.방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;
			for(int j=1;j<=V;j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current]=true;
			if(current == end) {
				break;
			}
			//2.current정점을 경유지로 해서 갈 수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(Edge edge : edgelist) {
				if(edge.from==current && !visited[edge.to] && distance[edge.to]> min+edge.weight){
					distance[edge.to] = min+edge.weight;
				}
			}
		}
		if(distance[i]>(V-1)*10) {
			sb.append("INF\n");
		}else {
			sb.append(distance[i]+"\n");				
		}
	}
}
