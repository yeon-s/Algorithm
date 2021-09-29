package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_16926_배열돌리기1_2 {

	static int N,M;
	static int[][] map;
	static int nowi,nowj;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int R;
	static int d;
	static Queue<Integer> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		R = sc.nextInt();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//입력 끝
		
		queue = new LinkedList<Integer>();
		int min = Math.min(N, M);
		for(int i=0;i<(min-1)/2;i++) {
			nowi=i;
			nowj=i;
			d=1;
			while(true) {
				int nexti=nowi+di[d];
				int nextj=nowj+dj[d];
				queue.offer(map[nexti][nextj]);
				nowi=nexti;
				nowj=nextj;
				if(nowi==N-1-i) {
					d=3;
				}else if(nowj==M-1-i) {
					d=0;
				}else if(nowi==0+i) {
					d=2;
				}else if(nowj==0+i) {
					d=1;
				}
				if(nowi==i && nowj==i) {
					break;
				}
			}
		}
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		//출력
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
	
}
