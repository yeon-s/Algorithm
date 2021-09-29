package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjListTest {

	static class Node{
		int vertex;		//인접정점 인덱스
		Node link;	
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	
	static int N;	//정점 개수
	static Node[] adjList;		//인접리스트(가중치 없음)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjList = new Node[N];
		int C = Integer.parseInt(br.readLine());	//간선 개수
		for(int i=0;i<C;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,adjList[from]);  
			adjList[to] = new Node(from,adjList[to]);
		}
		System.out.println("========bfs=========");
		bfs();
		System.out.println("========dfs=========");
		boolean[] visited = new boolean[N];
		dfs(0,visited);
	}

	private static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			System.out.println((char)(current+65));
			
			for(Node temp = adjList[current]; temp!=null;temp = temp.link) {
				if(!visited[temp.vertex]) {
					 queue.offer(temp.vertex);
					 visited[temp.vertex] =true;
				}
			}
			 
		}
	}
	
	private static void dfs(int current,boolean[] visited) {  		
		
		visited[current]=true;
		System.out.println((char)(current+65));
		
		for(Node temp = adjList[current]; temp!=null;temp = temp.link) {
			if(!visited[temp.vertex]) { 
				 
				 dfs(temp.vertex,visited);
			}
		}
	}
}
