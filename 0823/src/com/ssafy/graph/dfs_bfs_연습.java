package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_bfs_연습 {

	static int N;		//정점개수
	static boolean[][] adjMatrix;	//인접행렬
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];
		int C = Integer.parseInt(br.readLine());		//간선 개수
		
		for(int i=0;i<C;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
		}
		
		System.out.println("========bfs=========");
		bfs();
		System.out.println("========dfs=========");
		boolean[] visited = new boolean[N];
		dfs(0,visited);
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		boolean[] visited = new boolean[N];
		
		queue.offer(0);
		visited[0]=true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			
			for(int i=0;i<N;i++) {
				if(!visited[i] && adjMatrix[current][i]) {
					queue.offer(i);
					visited[i]=true;
					
				}
			}
		}
		
	}
	
	static void dfs(int current, boolean[] visited) {
		
		visited[current] = true;
		System.out.println(current);
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && adjMatrix[current][i]) {
				dfs(i,visited);
			}
		}
	}
}
