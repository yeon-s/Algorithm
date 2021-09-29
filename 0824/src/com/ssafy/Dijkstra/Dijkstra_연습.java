package com.ssafy.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra_연습 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N];
		int[] distance = new int[N];
		int[][] adjMatrix = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		int start=0;
		int end = N-1;
		final int max = Integer.MAX_VALUE;
		Arrays.fill(distance, max);
		
		distance[start] = 0;
		
		for(int i=0;i<N;i++) {
			int min = max;
			int current = -1;
			for(int j=0;j<N;j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			//min은 출발지에서 current까지의 보장된 최소거리(얘보다 짧은 애 없다)
			visited[current] = true;
			if(current==end) {
				break;
			}
			
			for(int j=0;j<N;j++) {
				if(!visited[j] && adjMatrix[current][j] !=0 && distance[j] > min+adjMatrix[current][j]) {
					distance[j] = min+adjMatrix[current][j];
				}
			}
		}
		System.out.println(distance[end]);
	}

}
