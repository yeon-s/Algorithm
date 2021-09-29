package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_17144_미세먼지안녕 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int R;
	static int C;
	static int T;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		while(T-->0) {
			spread();
			rotate();			
		}
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum +=map[i][j];
			}
		}
		System.out.println(sum+2);
		
		//테스트
//		spread();
//		rotate();
//		System.out.println(Arrays.deepToString(map));
	}

	
	static void spread() {
		int[][] copy = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] !=0 || map[i][j] !=-1) {
					int num = map[i][j]/5;
					int count=0;
					for(int d=0;d<4;d++) {
						int nexti = i+di[d];
						int nextj = j+dj[d];
						
						if(nexti<0 || nextj <0 || nexti>=R || nextj>=C || map[nexti][nextj]==-1) {
							continue;
						}
						copy[nexti][nextj] +=num;
						count++;
					}
					copy[i][j] -= num*count;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j] += copy[i][j];
			}
		}
	}
	
	static void rotate() {
		//공기 청정기 위치 찾기
		int up =-1;
		for(int i=0;i<R;i++) {
			if(map[i][0]==-1) {
				up=i;
				break;
			}
		}
		int down = up+1;
		
		//위에 돌리기
		for(int i=up-1;i>0;i--) {
			map[i][0]=map[i-1][0];
		}
		for(int j=0;j<C-1;j++) {
			map[0][j] = map[0][j+1];
		}
		for(int i=0;i<up;i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for(int j=C-1;j>1;j--) {
			map[up][j]=map[up][j-1];
		}
		map[up][1]=0;		//마지막 없애기
		
		//아래 돌리기
		for(int i=down+1;i<R-1;i++) {
			map[i][0] = map[i+1][0];
		}
		for(int j=0;j<C-1;j++) {
			map[R-1][j] = map[R-1][j+1];
		}
		for(int i=R-1;i>down;i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for(int j=C-1;j>1;j--) {
			map[down][j] = map[down][j-1];
		}
		map[down][1] =0;
	}
}
