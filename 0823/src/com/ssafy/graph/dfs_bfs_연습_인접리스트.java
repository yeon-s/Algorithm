package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_bfs_연습_인접리스트 {

	static int N;
	static Node[] adjList;
	
	static class Node{
		int Vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			Vertex = vertex;
			this.link = link;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		adjList = new Node[N];
		
		for(int i=0;i<C;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);		//무향그래프이므로, 첫번째 노드로 삽입하는 알고리즘
		}
		//입력 끝
		System.out.println("===============bfs=============");
		bfs();
		System.out.println("===============dfs=============");
		boolean[] visited = new boolean[N];
		dfs(0,visited);
	}
	
	static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			
			for(Node temp = adjList[current]; temp !=null;temp = temp.link) {
				if(!visited[temp.Vertex]) {
					queue.offer(temp.Vertex);
					visited[temp.Vertex]= true;
				}
			}
		}
	}

	static void dfs(int current,boolean[] visited) {
		visited[current] = true;
		System.out.println(current);
		
		for(Node temp = adjList[current]; temp !=null;temp = temp.link) {
			if(!visited[temp.Vertex]) {
				dfs(temp.Vertex,visited);
			}
		}
	}
}
