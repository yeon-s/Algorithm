package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3289_서로소집합 {

	static int n;
	static int[] parents;
	
	static void make() {
		for(int i=1;i<n+1;i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	static int union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) {
			return 1;
		}
		parents[bRoot] = aRoot;
		return 0;
	}
	static int unionCheck(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			make();
			for(int i=0;i<m;i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(str.nextToken());
				int a = Integer.parseInt(str.nextToken());
				int b= Integer.parseInt(str.nextToken());
				if(command==0) {
					union(a,b);
				}else {
					sb.append(unionCheck(a,b));					
				}
			}
			System.out.println("#"+tc+" "+sb);
		}

	}

}
