package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_7465_창용마을 {

	static int N;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			make();
			for(int i=0;i<M;i++) {
				union(sc.nextInt(),sc.nextInt());
			}
			int[] arr = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				arr[find(i)] +=1;
			}
			int count=0;
			for(int i=1;i<=N;i++) {
				if(arr[i]!=0) {
					count++;
				}
			}
			System.out.println("#"+tc+" "+count);
		}

	}
	
	static void make() {
		parents = new int[N+1];
		for(int i=1;i<N+1;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
		
	}
}
