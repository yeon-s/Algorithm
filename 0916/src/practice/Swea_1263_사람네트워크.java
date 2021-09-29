package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_1263_사람네트워크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] D = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					D[i][j] = Integer.parseInt(st.nextToken());
					if(D[i][j]==0 && i!=j) {
						D[i][j]=10000;
					}
				}
			}
			//입력 끝
			
			//System.out.println(Arrays.deepToString(D));
			
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
					}
				}
			}
			
			//System.out.println(Arrays.deepToString(D));
			
			int[] result = new int[N];
			for(int i=0;i<N;i++) {
				int sum=0;
				for(int j=0;j<N;j++) {
					sum += D[i][j];
				}
				result[i] = sum;
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				min = Math.min(min, result[i]);
			}
			System.out.println("#"+tc+" "+min);
			
		}
	}

}
