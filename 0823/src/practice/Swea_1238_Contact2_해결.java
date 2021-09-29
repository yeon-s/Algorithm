package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_1238_Contact2_해결 {

	static int N=100;
	static boolean[][] adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc =1;tc<=10;tc++) {
			int C = sc.nextInt();
			int start = sc.nextInt();
			adjMatrix = new boolean[N+1][N+1];
			
			for(int i=0;i<C/2;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adjMatrix[from][to]=true;
			}
			//입력 끝
			System.out.println("#"+tc+" "+bfs(start));
			
		}
		
	}
	
	static int bfs(int start) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] =true;
		int max=0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			max = 0;
			while(size-->0) {
				int current = queue.poll();
				
				max = Math.max(max, current);
				
				for(int i=1;i<N+1;i++) {
					if(!visited[i] && adjMatrix[current][i]) {
						queue.offer(i);
						visited[i]=true;
					}
				}
			}
			
		}
		return max;
	}


}
