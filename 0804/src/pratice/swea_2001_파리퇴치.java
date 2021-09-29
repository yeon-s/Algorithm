package pratice;

import java.util.Scanner;

public class swea_2001_파리퇴치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			int n = sc.nextInt();
			int m =sc.nextInt();
			
			int[][] map = new int[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}						
			//입력 끝
			
			int nowi=0;
			int nowj=0;
			int max=0;						//최대값 초기화
			
//			int right=0;
//			int down=0;
			while(true) {
				int sum=0;						//파리채 범위 내의 합(for문 안에)
				for(int i=nowi;i<m+nowi;i++) {
					for(int j=nowj;j<m+nowj;j++) {
						sum= sum+map[i][j];
					}
				}
				max=Math.max(max, sum);
				if(nowj<n-m) {
					nowj++;
					continue;
				}
				if(nowj==n-m) {
					nowj=0;
				}
				if(nowi<n-m) {
					nowi++;
					continue;
				}
				if(nowi==n-m) {
					break;
				}
			}
			System.out.println("#"+tc+" "+max);
		}

	}

}
