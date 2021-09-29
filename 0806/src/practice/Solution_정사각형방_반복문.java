package practice;

import java.util.Scanner;

public class Solution_정사각형방_반복문 {
	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			} // end input
			
			int ansCnt=0, ansRoom = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int nowi = i, nowj = j;
					int cnt = 1; // 자~! i,j에서 출발해보자!
					while(true) {
						boolean go = false; //nowi,nowj에서 이동가능한 옆방이 있나없나
						for(int d=0; d<4; d++) {
							int nexti = nowi + di[d];
							int nextj = nowj + dj[d];
							
							if(nexti<0 || nexti>=N || nextj<0 || nextj>=N) continue;
							
							if(map[nexti][nextj] == map[nowi][nowj]+1) {
								nowi = nexti;
								nowj = nextj;
								cnt++;
								go = true; // 이동가능한 옆방 있다!!!
							}
						}
						if(!go) {
							if(cnt > ansCnt) {
								ansCnt = cnt;
								ansRoom = map[i][j];
							}else if(cnt == ansCnt && ansRoom > map[i][j]) {
								ansRoom = map[i][j];
							}
							break; // while 탈출. 더이상 이동 못하니까
						}						
					} // end while
				} // end for j
			} // end for i
			
			System.out.println("#" + tc + " " + ansRoom + " " + ansCnt);
		} // end tc
	}
}
