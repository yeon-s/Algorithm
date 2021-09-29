package practice;

import java.util.Scanner;

public class Swea_1861_정사각형방2 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC= sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//입력 끝
			int[] result = new int[(n*n)+1];
			int max =0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int num = map[i][j];
					int nowi= i;
					int nowj= j;
					int count = search(nowi,nowj,n,map);
					max = Math.max(max, count);
					result[num]=count;
				}
			}
			System.out.print("#"+tc+" ");
			for(int k=1,size=result.length;k<size;k++) {
				if(result[k]==max) {
					System.out.println(k+" "+max);
					break;
				}
			}
		}

	}
	
	public static int search(int nowi,int nowj,int n,int[][] map) {
		int cnt=1;
		while(true) {
			boolean go = false;
			for(int d=0;d<4;d++) {
				int nexti = nowi+di[d];
				int nextj = nowj+dj[d];
				
				if(nexti<0 || nexti>=n || nextj<0 || nextj>=n) {
					continue;
				}
				if(map[nexti][nextj]==map[nowi][nowj]+1) {
					nowi = nexti;
					nowj = nextj;
					go = true;
					cnt++;
					break;
				}
			}
			if(!go) {
				return cnt;
			}
		}
	}
}
