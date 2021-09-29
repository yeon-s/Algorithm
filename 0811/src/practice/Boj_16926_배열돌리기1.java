package practice;

import java.util.Scanner;

public class Boj_16926_배열돌리기1 {

	static int N,M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int R = sc.nextInt();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//입력 끝
		while(R-->0) {
			rotate();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void rotate() {
		int my = (N-1)/2;
		int mx = (M-1)/2;
		for(int i=0;i<N;i++) {
			int first=map[i+1][0];
			for(int j=0;j<M;j++) {
				if(i<=my &&j>i) {
					map[i][j-1]=map[i][j];
				}else if(i>my && j<M-1){
					map[i][j+1]=map[i][j];
				}else if(i<N-1 && j>=mx) {
					map[i+1][j]=map[i][j];
				}else if(i>j && j>mx){
					map[i-1][j]=map[i][j];
				}
				
			}
			map[i+1][0]=first;
		}
	}
}
