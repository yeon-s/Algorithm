package practice;

import java.util.Scanner;

public class swea_1954_Sol {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			int nowi = 0, nowj = 0;
			int dir = 0; // right
			
			int num=1; // 1~25
			while(true) {
				map[nowi][nowj] = num;
				
				if(num == N*N)
					break;
				
				int nexti = nowi + di[dir];
				int nextj = nowj + dj[dir];
				
				if(nexti<0 || nexti>=N || nextj<0 || nextj>=N || map[nexti][nextj]!=0) {
					dir++;
					dir %= 4;
					continue;
				}
				
				nowi = nexti;
				nowj = nextj;
				num++;
			}
			
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
