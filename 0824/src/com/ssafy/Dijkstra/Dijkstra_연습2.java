package com.ssafy.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dijkstra_연습2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		int[] distance = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[0] = 0;
		int end = N-1;
		
		
		for(int i=0;i<N;i++) {
			int current = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if(current == end) {
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
