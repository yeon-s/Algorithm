package practice;

import java.util.Scanner;

public class Boj_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num= sc.nextInt();
		
		int[][] map = new int[100][100];
		
		for(int k=0;k<num;k++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			
			for(int i=y;i<y+10;i++) {
				for(int j=x;j<x+10;j++) {
					map[i][j] = 1;
				}
			}
			
		}
		int sum=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1) {
					sum++;
				}
			}
		}
		System.out.println(sum);

	}

}
