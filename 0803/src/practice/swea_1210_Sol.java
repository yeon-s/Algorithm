package practice;

import java.util.Scanner;

public class swea_1210_Sol {
	static int[][] map;
	static int ans;
	
	static int[] di = {0,0,-1};
	static int[] dj = {1,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int tcNum = sc.nextInt(); // 쓰잘데기 없이 이걸 입력으로 왜주는겨 ㅡㅡ ?
			
			map = new int[100][100];
			ans = -1;
			
			int nowi=99;
			int nowj=-1;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]==2)
						nowj = j;
				}
			} // end input
			
			while(true) {
				map[nowi][nowj] = 9;
				if(nowi==0) {
					ans = nowj;
					break;
				}
				
				for(int d=0; d<3; d++) { // 사다리 기어올라가는중이라 방향 left,right,up 세개만 보면 됨.
					int nexti = nowi + di[d];
					int nextj = nowj + dj[d];
					
					if(nextj<0 || nextj>=100) continue; // 좌우상 계산하다보니 쓰면 안되는 좌표가 나올때도 있네..; 걔들은 스킵
					
					if(map[nexti][nextj]==1) {
						nowi = nexti;
						nowj = nextj;
						break;
					}
				}
//				System.out.println(tc+":"+nowi+","+nowj);
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
//	static void print() {
//		for(int i=0; i<100; i++) {
//			for(int j=0; j<100; j++) {
//				System.out.print(map[i][j]==9?"#":map[i][j]);
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		} 
//		System.out.println("--------------------------");
//	}
	
	
}
