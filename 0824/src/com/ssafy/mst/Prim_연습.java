package com.ssafy.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prim_연습 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];		//인덱스에 해당하는 정점 각각마다 다른정점과의 연결비용 중 최소비용 저장하는 배열
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		//입력 끝
		int result = 0;
		minEdge[0] =0;
		
		for(int i=0;i<N;i++) {
			//1.민엣지 중에서 최소인 값을 가진 정점 찾기
			int min = Integer.MAX_VALUE;		//현재 활성화된 간선 중 최소를 저장할 변수
			int minVertex=-1;		//민엣지 중 최소인 값을 가진 정점을 저장할 변수
			for(int j=0;j<N;j++) {
				if(!visited[j] && min>minEdge[j]) {
					min  = minEdge[j];
					minVertex = j;
				}
			}
			result += min;
			visited[minVertex] =true;
			
			//2.현재 추가된 정점으로부터 갈 수 있는 정점들 중 최소가 있는 지 보고 있다면 민엣지 업데이트
			for(int j=0;j<N;j++) {
				if(!visited[j] && adjMatrix[minVertex][j] !=0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(result);
	}

}
