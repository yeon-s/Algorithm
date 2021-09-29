package com.ssafy.mst;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {

	static int V,E;
	static Edge[] edgelist;
	static int[] parents;	//부모원소를 관리(트리처럼 사용)
	
	private static void make() {
		parents = new int[V];
		//모든 원소를 자신을 대표자로 만듦
		for(int i=0;i<V;i++) {
			parents[i] = i;
		}
		
	}
	//a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if(a==parents[a]) {
			//자신이 대표자
			return a;
		}
		return parents[a] = find(parents[a]);	//자신이 속한 집합의 대표자를 자신의 부모로 만듦:path compression
	}
	//두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static boolean union(int a,int b) {
		 int aRoot = find(a);
		 int bRoot = find(b);
		 if(aRoot==bRoot) {
			 return false;		//이미 같은 집합으로 합치지 않음
		 }
		 parents[bRoot] = aRoot;
		 return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		//간선리스트 작성
		edgelist = new Edge[E]; 
		
		for(int i=0;i<E;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			edgelist[i] = new Edge(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
		}
		
		//입력 끝
		Arrays.sort(edgelist);		//오름차순 정렬
		
		make();		//모든 정점을 각각의 집합으로 만들기
		
		//간선 하나씩 시도하며 트리 만들어감.
		int cnt=0;
		int result =0;
		for(Edge edge : edgelist) {
			if(union(edge.from, edge.to)) {  
				result += edge.weight;
				cnt++;
				if(cnt == V-1) {	//신장트리 완성
					break;		
				}
			}
		}
		System.out.println(result);
		
	}
	
	
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			
			return weight-o.weight;		//부호가 같다면
			//다르면 return Integer.compare(weight,o.weight);
		}
	}
}
