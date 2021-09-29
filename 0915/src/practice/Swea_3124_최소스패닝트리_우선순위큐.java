package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Swea_3124_최소스패닝트리_우선순위큐 {

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
			long result =0;
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(1, null, 0));
			while (!pq.isEmpty()) {
				// 1. 현재 방문 지점 (갸장 가까운 곳)
				Node currentNode = pq.poll();
				int current = currentNode.vertex;
				int min = currentNode.weight;

				if (visited[current]) {
					continue;
				}
				result += min;
				// 2. 현재 방문 지점 기준으로 업데이트 하기.
				visited[current] = true;
				for (Node temp = adjList[current]; temp !=null; temp = temp.link) {
					if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight ) {
						minEdge[temp.vertex] = temp.weight;
						pq.add(new Node(temp.vertex, null,minEdge[temp.vertex]));
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}

	}
	
	static class Node implements Comparable<Node>{
		int vertex;
		Node link;
		int weight;
		public Node(int vertex, Node link, int weight) {
			super();
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.weight>o.weight) {
				return +1;			
			}else {
				return -1;
			}
		}
		
		
		
	}
}
