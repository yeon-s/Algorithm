package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Swea_1238_Contact {

	static boolean[][] Matrix;
	static int max;
	static List<Node> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			Matrix = new boolean[101][101];
			int data = sc.nextInt();
			int start = sc.nextInt();
			
			for(int i=0;i<data/2;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				Matrix[from][to] = true;
			}
			//입력 끝
			//bfs(start);
			max = 0;
			int maxNum=0;
			list = new ArrayList<>();
			boolean[] visited = new boolean[101];
			dfs(start,0,visited);
			for(int i=0;i<list.size();i++) {
				if(list.get(i).depth==max) {
					maxNum = Math.max(maxNum, list.get(i).data);
				}
			}
			System.out.println("#"+tc+" "+maxNum);
		}
		
	}
	
//	static void bfs(int current) {
//		Queue<Integer> queue = new LinkedList<Integer>();
//		boolean[] visited = new boolean[101];
//		
//		queue.offer(current);
//		visited[current]=true;
//		int depth=0;
//		
//		while(!queue.isEmpty()) {
//			current = queue.poll();
//			depth++;
//			for(int i=1;i<101;i++) {
//				if(!visited[i] && Matrix[current][i]) {
//					queue.offer(i);
//					visited[i]=true;
//				}
//			}
//		}
//	}

	static void dfs(int current, int depth,boolean[] visited) {
		visited[current] = true;
		
		max = Math.max(max, depth);
		list.add(new Node(depth, current));
		
		for(int i=1;i<101;i++) {
			if(!visited[i] && Matrix[current][i]) {
				dfs(i,depth+1,visited);
			}
		}
	}
	
	static class Node{
		int depth;
		int data;
		public Node(int depth, int data) {
			super();
			this.depth = depth;
			this.data = data;
		}
		
	}
}
