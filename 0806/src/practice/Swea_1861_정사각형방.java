package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_1861_정사각형방 {
	
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			int[] result = new int[n*n+1];
			int max=0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//입력 끝
				int count=0;
				int num=0;
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
							int nowi=i;
							int nowj=j;
							num = map[i][j];
							count =search(nowi,nowj,map,n);
							result[num]=count;
							max = Math.max(max, count);
					}
				}
			int ans =0;
			for(int i=0;i<result.length;i++) {
				if(result[i]==max) {
					ans=i;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans+" "+max);
		}
		
		
	}
	
	public static int search(int nowi,int nowj,int[][] map,int n) {
		int cnt=1;
		while(true) {
			boolean go =false;
			for (int d = 0; d < 4; d++) {
				int nexti = nowi + di[d];
				int nextj = nowj + dj[d];
				if (nexti<0 || nexti>=n||nextj<0||nextj>=n) {
					continue;
				}
				if(map[nexti][nextj] == map[nowi][nowj]+ 1) {
					nowi = nexti;
					nowj = nextj;
					cnt++;
					go=true;
				}
			}
			if(!go) {
				return cnt;
			}
		}
	}
}
