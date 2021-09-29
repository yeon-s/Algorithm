package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1753_최단경로2_성공 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[V+1];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		//입력 끝
		
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		final int max = Integer.MAX_VALUE;
		Arrays.fill(distance, max);
		distance[start] = 0;
		
		for(int i=1;i<=V;i++) {
			int min = max;
			int current = -1;
			for(int j=1;j<=V;j++) {
				if(!visited[j] && min> distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			if(current ==-1) {
				break;
			}
			visited[current] = true;
			
			for(Node temp = adjList[current];temp !=null ;temp = temp.link) {
				if(!visited[temp.data] && distance[temp.data] > min+temp.weight) {
					distance[temp.data] = min+temp.weight;
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if(distance[i]==max) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
			
		}

	}

	static class Node{
		int data;
		int weight;
		Node link;
		public Node(int data, int weight, Node link) {
			super();
			this.data = data;
			this.weight = weight;
			this.link = link;
		}
		
	}
}
