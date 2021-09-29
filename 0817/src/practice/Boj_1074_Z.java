package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1074_Z {

	static int[][] map;
	static int num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		
		num=0;
		divide((int)Math.pow(2, N),r,c);
		System.out.println(num);
		
	}
		
	static void divide(int n,int r,int c) {
		int one = ((n/2)*(n/2));
		if(n==2) {
			if(r==0&&c==0) {
				num=num;
			}
			if(r==0&&c==1) {
				num=num+1;
			}
			if(r==1&&c==0) {
				num=num+2;
			}
			if(r==1&&c==1) {
				num=num+3;
			}
			
			return;
		}
		if(r<n/2&&c<n/2) {
		//1번째
			num= num;
			divide(n/2,r,c);
		}
		if(r<n/2&&c>=n/2) {
		//2번째		
			num=num+one;
			divide(n/2,r,c-n/2);
		}
		if(r>=n/2&&c<n/2) {
			num=num+one*2;
		//3번째
			divide(n/2,r-n/2,c);
		}
		if(r>=n/2&&c>=n/2) {
			num=num+one*3;
			divide(n/2,r-n/2,c-n/2);
		//4번째	
		}
		
	}
}
