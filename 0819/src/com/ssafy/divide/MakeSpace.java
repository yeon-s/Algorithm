package com.ssafy.divide;

public class MakeSpace {

	static int green,white;
	static int[][] map;
	public static void main(String[] args) {
		
		int n =8;
		map = new int[][] {
			
		};
		cut(0,0,n);
		System.out.println(white);
		System.out.println(green);

	}
	
	private static void cut(int r,int c, int size) {
		
		int sum=0;
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				sum += map[i][j];
			}
		}
		
		//같은색인지 체크
		if(sum==size*size) {
			green++;
		}else if(sum==0) {
			white++;
		}else {
			int half = size/2;
			
			cut(r,c,half);
			cut(r,c+half,half);
			cut(r+half,c,half);
			cut(r+half,c+half,half);
		}
	}
}
