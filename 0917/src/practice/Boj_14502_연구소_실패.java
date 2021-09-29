package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Boj_14502_연구소_실패 {

	static int N;
	static int M;
	static int[][] map;
	static int min;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static List<Point> firstVirus;
	static List<Point> list;
	static Point[] result;
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
		firstVirus = new ArrayList<>();
		list = new ArrayList<>();
		result = new Point[3];
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					list.add(new Point(i, j));
				}
				if(map[i][j]==2) {
					firstVirus.add(new Point(i, j));
				}
			}
		}
		
		comb(0,0);
		System.out.println(N*M-min);
	}

	static void comb(int cnt,int start) {
		if(cnt==3) {
			int[][] simul = map;
			for(int i=0;i<3;i++) {
				Point point = result[i];
				simul[point.i][point.j]=1;
			}
			
			simul = bfs(firstVirus,simul);
			
			int sum = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(simul[i][j]!=0) {
						sum++;  
					}
					if(sum>min) {
						return;
					}
				}
			}
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=start;i<list.size();i++) {
			result[cnt]=list.get(i);
			comb(cnt+1,i+1);
		}
		
	}
	
	static int[][] bfs(List<Point> firstVirus,int[][] simul) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][] visited2 = new boolean[N][M];
		
		for(int i=0;i<firstVirus.size();i++) {
			queue.offer(firstVirus.get(i));
			visited2[firstVirus.get(i).i][firstVirus.get(i).j] = true;
		}
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			simul[current.i][current.j]=2;
			
			for(int d=0;d<4;d++) {
				int nexti = current.i+di[d];
				int nextj = current.j+dj[d];
				
				if(nexti<0 || nextj<0 || nexti>=N || nextj>=M) {
					continue;
				}
				if(!visited2[nexti][nextj] && simul[nexti][nextj] ==0) {
					queue.offer(new Point(nexti, nextj));
					visited2[nexti][nextj] = true;
				}
			}
			
		}
		return simul;
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