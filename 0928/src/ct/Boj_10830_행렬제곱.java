package ct;

import java.util.Scanner;

public class Boj_10830_행렬제곱 {

	static int T =1000;
	static int[][] m;
	static int N;
	static int B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		B = sc.nextInt();
		m = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				m[i][j] = sc.nextInt();
			}
		}
		
		int[][] mm =matrix(B);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(mm[i][j]+" ");
			}
			System.out.println();
		}
	}

	static int[][] matrix(long y){
		int[][] res = new int[N][N];
		for(int i=0;i<N;i++) {
			res[i][i]=1;
		}
		
		while(y>0L) {
			if(y%2==1L) {
				res = mul(res,m);
			}
			y/=2L;
			res = mul(m,m);
		}
		return res;
		
	}

	private static int[][] mul(int[][] r, int[][] x) {
		int[][] res = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int t=0;
				for(int k=0;j<N;k++) {
					t = (t%T + (r[i][k]*x[k][j]%T))%T;
				}
				res[i][j] = t%T;
			}
		}
		return null;
	}
}
