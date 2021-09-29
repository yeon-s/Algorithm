package com.ssafy.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prim_연습2 {

	static int N;
	static boolean[] visited;
	static int[] minEdge;
	static int[][] adjMatrix; 
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		minEdge = new int[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		//입력 끝
		visited = new boolean[N];
		minEdge[0] = 0;
		sum=0;
		prim();
		System.out.println(sum);

	}
	
	static void prim() {

		for(int i=0;i<N;i++) {
			//거리가 최소인 정점 찾기
			int current=-1;
			int min = Integer.MAX_VALUE;
			
			for(int j=0;j<N;j++) {
				if(!visited[j] && min>minEdge[j]) {
					min=minEdge[j];
					current=j;
				}
			}
			visited[current]=true;
			sum +=min;
			
			//현재 추가된 정점으로부터 minDis 업데이트
			for(int j=0;j<N;j++) {
				if(!visited[j] && adjMatrix[current][j] !=0 && minEdge[j]>adjMatrix[current][j]) {
					minEdge[j] = adjMatrix[current][j];
				}
			}
		}
	}
}
