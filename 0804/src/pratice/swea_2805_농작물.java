package pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_2805_농작물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC =Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int sum =0;
			
			for(int i=0;i<n;i++) {
				String str = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(str.substring(j,j+1));
				}
			}
			
			for(int i=0;i<n;i++) {
				if(i<(n/2)) {
					for(int j=(n/2)-i;j<=i+(n/2);j++) {
						sum=sum+map[i][j];
					}
				}else if(i==(n/2)) {
					for(int j=0;j<n;j++) {
						sum=sum+map[i][j];
					}
				}else if(i>(n/2)) {
					for(int j=(n/2)-(n-1-i);j<=(n-1-i)+(n/2);j++) {
						sum=sum+map[i][j];
					}
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}

}
