package practice;

import java.util.Scanner;

public class swea_1210_사다리2 {

	static int[] di= {0,0,-1};
	static int[] dj = {-1,1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int trash = sc.nextInt();
			int[][] map = new int [100][100];
			int result =-1;
			
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					map[i][j]= sc.nextInt();
				}
			}
			//입력 끝
			int nowi=99;
			int nowj=-1;
			for(int i=0;i<100;i++) {
				if(map[99][i]==2) {
					nowj=i;
				}
			}
			
			while(true) {
				map[nowi][nowj]=3;
				if(nowi==0) {
					result=nowj;
					break;
				}
				boolean up=true;
				
				
				for(int d=0;d<2;d++) {
					int nexti= nowi+di[d];
					int nextj = nowj+dj[d];
					if(nextj<0 || nextj>=100) {
						continue;
					}
					if(map[nexti][nextj]==1) {
						nowi =nexti;
						nowj=nextj;
						up=false;
						break;
					}
				}
				if(up) {
					nowi = nowi+di[2];
					nowj = nowj+dj[2];
				}
			}
			System.out.println("#"+tc+" "+result);
			
		}
		

	}

}
