package practice;

import java.util.Scanner;

public class Swea_4012_요리사 {

	static int N;
	static int[] arr;
	static boolean[] isSelected;
	static int[][] map;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//입력 끝
			arr= new int[N];
			isSelected = new boolean[N];
			for(int i=0;i<N;i++) {
				arr[i] =i;
			}
			min=Integer.MAX_VALUE;
			comb(0,0);
			System.out.println("#"+tc+" "+min);
		}
	}

	static void comb(int target,int cnt) {
		if(cnt==N/2) {
			int A=0;
			int B=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(isSelected[i] && isSelected[j] && i!=j) {
						A += map[i][j];
					}else if(isSelected[i]==false && isSelected[j]==false && i!=j) {
						B +=map[i][j];
					}
				}
			}
			
			min =Math.min(min, Math.abs(A-B));
			return;
		}
		if(target==N) {
			
			return;
		}
		
		
		isSelected[target] = true;
		comb(target+1,cnt+1);
		isSelected[target] = false;
		comb(target+1,cnt);
	}
}
