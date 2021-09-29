package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4485_녹색옷입은애가젤다지2 {

	static int N;
	static int[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int min;
	static int[][] minDist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=0;
		while(true) {
			tc++;
			N = Integer.parseInt(br.readLine());
			
			if(N==0) {
				break;
			}
			
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			boolean[][] visited = new boolean[N][N];
			min = Integer.MAX_VALUE;
			minDist = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					minDist[i][j] = min;
				}
			}
			dfs(0,0,visited,0);
			System.out.println("Problem "+tc+": "+minDist[N-1][N-1]);
		}
		

	}

	static void dfs(int nowi,int nowj,boolean[][] visited, int price) {
		visited[nowi][nowj] = true;
		price += map[nowi][nowj]; 
		
		if(price>minDist[nowi][nowj]) {
			return;
		}else {
			minDist[nowi][nowj]= price;			
		}
		
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj <0 || nexti>=N || nextj>=N) {
				continue;
			}
			if(!visited[nexti][nextj]) {
				dfs(nexti,nextj,visited,price);
				visited[nexti][nextj] = false;
			}
		}
	}
}
