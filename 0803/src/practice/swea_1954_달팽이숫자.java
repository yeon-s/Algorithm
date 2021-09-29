package practice;


import java.util.Scanner;

public class swea_1954_달팽이숫자 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for(int tc=1;tc<=TC;tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			int nowi = 0;
			int nowj = 0;
			
			int dir = 0;
			
			int[] di = {0,1,0,-1};
			int[] dj = {1,0,-1,0};
			
			
			
			int k=1;
			while (true) {
				arr[nowi][nowj] = k;
				if (k == n * n) {
					break;
				}
				int nexti = nowi + di[dir];
				int nextj = nowj + dj[dir];
				if (nexti >= 0 && nexti < n && nextj < n && nextj >= 0 && arr[nexti][nextj] == 0) {
					nowi = nexti;
					nowj = nextj;
					k++;

				} else {
					nexti = nowi;
					nextj = nowj;
					dir++;
					if (dir == 4) {
						dir = 0;
					}

				}

			}
		
			System.out.println("#"+tc);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}
