package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1600_말이되고픈원숭이_실패 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited;
	static int H;
	static int W;
	static int min;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
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
		int[][] D = new int[H][W];
		D[0][0]=0;
		visited = new boolean[H][W];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				int min = Integer.MAX_VALUE;
				
				for(int d=0;d<4;d++) {
					int nexti = i+di[d];
					int nextj = j+dj[d];
					
				}
				
				D[i][j] = min; 
			}
		}
	}

	static void dfs(int nowi,int nowj,int num,int K) {
		if(num>min) {
			return;
		}
		if(nowi ==H-1 && nowj==W-1) {
			min = Math.min(min, num);
		}
		visited[nowi][nowj] = true;
		
		if(K>0) {
			
		}
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj <0 || nexti>=H || nextj>=W ) {
				continue;
			}
			if(!visited[nexti][nextj] && map[nexti][nextj]==0) {
				dfs(nexti,nextj,num+1,K);
			}
		}
	}
}
