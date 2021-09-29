package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Boj_14502_연구소4 {

	static int N;
	static int M;
	static int[][] map;
	static List<Point> zeroList;
	static Point[] result;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//입력 끝
		zeroList = new ArrayList<>();
		result = new Point[3];
		max = -1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					zeroList.add(new Point(i, j));
				}
			}
		}
		
		comb(0,0);
		System.out.println(max);
		
	}
	
	static void comb(int start,int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
//		if(target==zeroList.size()) {
//			return;
//		}
		
		for(int i=start;i<zeroList.size();i++) {
			result[cnt] = zeroList.get(i);
			comb(i+1,cnt+1);
		}
		
//		result[cnt] = zeroList.get(target);
//		comb(target+1,cnt+1);
//		comb(target+1,cnt);
		
	}
	
	static void bfs() {
		int[][] copyMap = new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for(Point p : result) {
			copyMap[p.i][p.j]=1;
		}
		
		Queue<Point> queue = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]==2) {
					queue.offer(new Point(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d=0;d<4;d++) {
				int nexti = current.i+di[d]; 
				int nextj = current.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=M ) {
					continue;
				}
				if(copyMap[nexti][nextj]==0) {
					copyMap[nexti][nextj] =2;					
					queue.offer(new Point(nexti, nextj));
				}
			}
		}
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]==0) {
					sum++;
				}
			}
		}
		max = Math.max(max, sum);
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