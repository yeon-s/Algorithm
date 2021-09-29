package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149_RGB거리_실패 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
//		Select[] D = new Select[N+1];
//		D[1] = new Select(matrix[1][0], 'R');
//		
//		for(int i=2;i<=N;i++) {
//			int min = Integer.MAX_VALUE;
//			
//			if(D[i-1].selected != 'R' && D[i-1].sum+matrix[i][0]<min) {
//				min = D[i-1].sum+matrix[i][0];
//				D[i] = new Select(min, 'R');
//			}
//			if(D[i-1].selected != 'G' && D[i-1].sum+matrix[i][1]<min) {
//				min = D[i-1].sum+matrix[i][1];
//				D[i] = new Select(min, 'G');
//			}
//			if(D[i-1].selected != 'B' && D[i-1].sum+matrix[i][2]<min) {
//				min = D[i-1].sum+matrix[i][2];
//				D[i] = new Select(min, 'B');
//			}
//			
//		
//		}
		int min = Integer.MAX_VALUE;
		min = Math.min(min, find(N,matrix,0,'R'));
		min = Math.min(min, find(N,matrix,1,'G'));
		min = Math.min(min, find(N,matrix,2,'B'));
		System.out.println(min);

	}

	static class Select{
		int sum;
		char selected;
		public Select(int sum, char selected) {
			super();
			this.sum = sum;
			this.selected = selected;
		}
		
		
	}
	static int find(int N, int[][] matrix,int start,char startC) {
		Select[] D = new Select[N+1];
		D[1] = new Select(matrix[1][start], startC);
		
		for(int i=2;i<=N;i++) {
			int min = Integer.MAX_VALUE;
			
			if(D[i-1].selected != 'R' && D[i-1].sum+matrix[i][0]<min) {
				min = D[i-1].sum+matrix[i][0];
				D[i] = new Select(min, 'R');
			}
			if(D[i-1].selected != 'G' && D[i-1].sum+matrix[i][1]<min) {
				min = D[i-1].sum+matrix[i][1];
				D[i] = new Select(min, 'G');
			}
			if(D[i-1].selected != 'B' && D[i-1].sum+matrix[i][2]<min) {
				min = D[i-1].sum+matrix[i][2];
				D[i] = new Select(min, 'B');
			}
			
		
		}
		return D[N].sum;
	}
}
