package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260_DFS_BFS {

	static int N;
	static boolean[][] Matrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		Matrix = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(str.nextToken());
			int to = Integer.parseInt(str.nextToken());
			Matrix[from][to] = true;
			Matrix[to][from]=true;
		}
		//입력 끝
		boolean[] visited = new boolean[N+1];
		dfs(V,visited);
		System.out.println();
		bfs(V);
	}

	static void bfs(int current) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(current);
		visited[current] = true;
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current+" ");
			
			for(int i=1;i<N+1;i++) {
				if(!visited[i] && Matrix[current][i]) {
					queue.offer(i);
					visited[i]=true;
				}
			}
		}
	}
	
	static void dfs(int current, boolean[] visited) {
		
		visited[current] =true;
		System.out.print(current+" ");
		
		for(int i=1;i<N+1;i++) {
			if(!visited[i] && Matrix[current][i]) {
				
				dfs(i,visited);
			}
		}
		
	}
}
