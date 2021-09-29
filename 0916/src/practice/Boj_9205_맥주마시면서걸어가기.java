package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9205_맥주마시면서걸어가기 {

	static int n;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc =1;tc<=TC;tc++) {
			n = Integer.parseInt(br.readLine());
			
			Point[] arr = new Point[n+2];
			
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			//입력 끝
			
			boolean[] visited = new boolean[n+2];
			flag = false;
			//dfs(arr,visited,0);
			bfs(arr);
			if(flag) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
			
		}

	}
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static void dfs(Point[] arr,boolean[] visited,int current) {
		if(flag) {
			return;
		}
		
		if(current == n+1) {
			flag =true;
			return;
		}
		
		visited[current] = true;
				
		for(int i=0;i<n+2;i++) {
			if(!visited[i] && (Math.abs(arr[current].x-arr[i].x)+Math.abs(arr[current].y-arr[i].y))<=1000 ) {
				dfs(arr,visited,i);
			}
		}
	}
	
	static void bfs(Point[] arr) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n+2];
		
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(current == n+1) {
				flag = true;
				return;
			}
			
			for(int i=0;i<n+2;i++) {
				if(!visited[i] && (Math.abs(arr[current].x-arr[i].x)+Math.abs(arr[current].y-arr[i].y))<=1000) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
