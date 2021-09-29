package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1600_말이되고픈원숭이4 {

	static int W;
	static int H;
	static int[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[] horseI = {-2,-1,1,2,2,1,-1,-2};
	static int[] horseJ = {1,2,2,1,-1,-2,-2,-1};
	static int K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		System.out.println(bfs());
		
	}

	static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[H][W][K+1];
		int k =K;
		queue.offer(new Point(0,0,k));
		visited[0][0][k] = true;
		int depth =0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				Point current = queue.poll();
				if(current.i == H-1 && current.j==W-1) {
					return depth;
				}
				
				if(current.k>0) {
					for(int d=0;d<8;d++) {
						int nexti = current.i+horseI[d];
						int nextj = current.j+horseJ[d];
						
						if(nexti<0 || nextj <0 || nexti>=H || nextj >=W || map[nexti][nextj]==1) {
							continue;
						}
						if(!visited[nexti][nextj][current.k-1] && map[nexti][nextj]==0) {
							queue.offer(new Point(nexti, nextj,current.k-1));
							visited[nexti][nextj][current.k-1] = true;
						}
					}
				}
				
				for (int d = 0; d < 4; d++) {
					int nexti = current.i + di[d];
					int nextj = current.j + dj[d];

					if (nexti < 0 || nextj < 0 || nexti >= H || nextj >= W || map[nexti][nextj] == 1) {
						continue;
					}
					if(!visited[nexti][nextj][current.k] && map[nexti][nextj]==0) {
						queue.offer(new Point(nexti, nextj,current.k));
						visited[nexti][nextj][current.k] = true;
					}
				}

			}
			depth++;
		}
		return -1;
	}
	
	static class Point{
		int i;
		int j;
		int k;
		public Point(int i, int j,int k) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
		}
		
	}
}
