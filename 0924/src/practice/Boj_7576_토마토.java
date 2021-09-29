package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576_토마토 {

	static int N;
	static int M;
	static int[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		boolean zero = true;		//처음부터 0이 없으면
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					zero = false;
					break;
				}
			}
		}
		
		if(zero) {
			System.out.println(0);
			return;
		}
		
		int result = bfs();
		
		
		boolean noAll = false;		//모두 익지 못하는 상황
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					noAll = true;
					break;
				}
			}
		}
		if(noAll) {
			System.out.println(-1);
		}else {
			System.out.println(result-1);
		}
	}

	static int bfs() {
		Queue<Point> queue =new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					queue.offer(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		int day=0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point current = queue.poll();
				
				for(int d=0;d<4;d++) {
					int nexti = current.i+di[d];
					int nextj = current.j+dj[d];
					
					if(nexti<0 || nextj <0 || nexti>N-1 || nextj>M-1 || map[nexti][nextj]==-1) {
						continue;
					}
					if(!visited[nexti][nextj] && map[nexti][nextj]==0) {
						queue.offer(new Point(nexti, nextj));
						visited[nexti][nextj] = true;
						map[nexti][nextj]=1;
					}
				}
				
			}
			day++;
		}
		return day;
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
