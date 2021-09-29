package practice;

import java.util.Scanner;

public class Solution_정사각형방_재귀 {
	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	static int ansCnt, ansRoom;
	static int N;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			} // end input
			
			ansCnt = 0;
			ansRoom = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					solve(i, j, 1, i, j);
				} // end for j
			} // end for i
			
			System.out.println("#" + tc + " " + ansRoom + " " + ansCnt);
		} // end tc
	}
	
	static void solve(int nowi, int nowj, int cnt, int si, int sj) {
		for(int d=0; d<4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];
			
			if(nexti<0 || nexti>=N || nextj<0 || nextj>=N) continue;
			
			if(map[nexti][nextj] == map[nowi][nowj]+1) {
				solve(nexti, nextj, cnt+1, si, sj);
			}
		}
		
		if(ansCnt < cnt) {
			ansCnt = cnt;
			ansRoom = map[si][sj];
		}else if(ansCnt == cnt && ansRoom > map[si][sj]) {
			ansRoom = map[si][sj];
		}
	}
}
