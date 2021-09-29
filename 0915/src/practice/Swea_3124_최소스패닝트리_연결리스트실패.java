package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_3124_최소스패닝트리_연결리스트실패 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			Node[] adjList = new Node[V+1];
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to, adjList[from], weight);
				adjList[to] = new Node(from, adjList[to], weight);
			}
			
			boolean[] visited = new boolean[V+1];
			int[] minEdge = new int[V+1];
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[1] =0;
			int result =0;
			
			for(int i=1;i<=V;i++) {
				int current = -1;
				int min = Integer.MAX_VALUE;
				
				for(int j=1;j<=V;j++) {
					if(!visited[j] && min>minEdge[j]) {
						min = minEdge[j];
						current = j;
					}
				}
				
				visited[current] = true;
				result +=min;
				
				for(Node temp = adjList[current]; temp !=null; temp = temp.link) {
					if(!visited[temp.vertex] && minEdge[temp.vertex]> temp.weight) {
						minEdge[temp.vertex] = temp.weight;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}

	}
	
	static class Node{
		int vertex;
		Node link;
		int weight;
		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
		
		
		
	}
}
