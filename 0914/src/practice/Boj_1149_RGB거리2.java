package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149_RGB거리2 {

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
		
		for(int i=1;i<=N;i++) {
			
			matrix[i][0] = matrix[i][0]+Math.min(matrix[i-1][1], matrix[i-1][2]);
			matrix[i][1] = matrix[i][1]+Math.min(matrix[i-1][0], matrix[i-1][2]);
			matrix[i][2] = matrix[i][2]+Math.min(matrix[i-1][0], matrix[i-1][1]);
		}
		int min = Math.min(matrix[N][0], matrix[N][1]);
		min = Math.min(min, matrix[N][2]);
		System.out.println(min);
	}

}
