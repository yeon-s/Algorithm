package practice;

import java.util.Scanner;

public class swea_1210_사다리 {
	static int[][] map;
	static int ans;
	
	static int[] di = {0,0,-1};		
	static int[] dj = {1,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int num = sc.nextInt();
			
			map= new int[100][100];
			ans =-1;
//			int[][] map = new int[100][100];
			
		
			int nowi=99;
			int nowj=-1;
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==2)
						nowj = j;
				}
			}
		
//			int nowi=99;
//			int nowj=-1;
			
//			for(int i=0;i<100;i++) {
//				for(int j=0;j<100;j++) {
//					if(map[i][j]==2) {
//						nowi=i;
//						nowj=j;
//					}
//				}
//			}
			
//			int[] di = {0,0,-1};		
//			int[] dj = {1,-1,0};	
			
			while(true) {
				map[nowi][nowj] = 9;
				if(nowi==0) {
					ans=nowj;
					break;
				}
				
				for(int d=0;d<3;d++) {
					int nexti= nowi+di[d];
					int nextj = nowj+dj[d];
					
					if(nextj<0 || nextj>=100) {
						continue;
					}
					
					if(map[nexti][nextj]==1) {
						nowi=nexti;
						nowj=nextj;
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}

	}
	
}
