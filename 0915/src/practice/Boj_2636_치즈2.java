package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2636_치즈2 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static int h;
	static int w;
	static Queue<Point> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		for(int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		boolean[][] visited = new boolean[h][w];
		queue = new LinkedList<>();
		int size=0;
		int time =0;
		
		dfs(0,0,visited);

		
		while(!queue.isEmpty()) {
			size = queue.size();
			time++;
			for(int i=0;i<size;i++) {
				Point current = queue.poll();
				map[current.i][current.j]=0;
				dfs(current.i,current.j,visited);
			}
		}
		
		System.out.println(time);
		System.out.println(size);
		
//		for(int i=0;i<h;i++) {
//			for(int j=0;j<w;j++) {
//				if(!visited[i][j] && map[i][j]==0) {
//					dfs(i,j,visited);
//					size = queue.size();
//	
//					while(!queue.isEmpty()) {
//						Point current = queue.poll();
//						map[current.i][current.j]=0;
//					}
//					time++;
//				}
//			}
//		}
//		

	}
	
	static void dfs(int nowi,int nowj,boolean[][] visited) {
		visited[nowi][nowj] = true;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti <0 || nextj <0 || nexti>=h || nextj >=w) {
				continue;
			}
			if(!visited[nexti][nextj] && map[nexti][nextj]==0) {
				dfs(nexti,nextj,visited);
			}else if(!visited[nexti][nextj] && map[nexti][nextj]==1) {
				queue.offer(new Point(nexti, nextj));
				visited[nexti][nextj] = true;
			}
		}
	}
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}
