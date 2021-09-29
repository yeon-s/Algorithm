package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1251_하나로3 {

	static int N;
	static boolean[] visited;
	static long[] minEdge;
	static Node[] nodes;
	static double result;
	static double E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			
			visited = new boolean[N];
			minEdge = new long[N];  
			
			nodes = new Node[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer str = new StringTokenizer(br.readLine());
				
			
			for(int i=0;i<N;i++) {
				nodes[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(str.nextToken()));
				minEdge[i]=Long.MAX_VALUE;
			}
			
			E = Double.parseDouble(br.readLine());
			//입력 끝
			
			for(int n=0;n<N;n++) {
				visited = new boolean[N];
				
				for(int i=0;i<N;i++) {
					
					minEdge[n]=Long.MAX_VALUE;
				}
				result = 0;
				method(n);
				System.out.println(Math.round(result));
			}
			
			
			
			
		}
		
	}

	static void method(int a) {
		minEdge[a]=0;
		for(int i=0;i<N;i++) {
			//1.신장트리에 포함되지 않은 정점 중에 최소간선비용 정점 찾기
			long min = Long.MAX_VALUE;
			int minVertex =-1;		//최소간선비용을 가진 정점번호
			for(int j=0;j<N;j++) {
				if(!visited[j] && min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			visited[minVertex] =true;
			result += (double)min*E;
			
			//2.선택된 정점을 기준으로 신장트리에 연결되지 않은 타 정점과의 간선비용 최소로 업데이트
			for(int j=0;j<N;j++) {
				if(!visited[j] && minEdge[j]> Math.abs(nodes[minVertex].x-nodes[j].x)+Math.abs(nodes[minVertex].y-nodes[j].y)) {
					minEdge[j] = (long)(Math.pow(Math.abs(nodes[minVertex].x-nodes[j].x), 2)+Math.pow(Math.abs(nodes[minVertex].y-nodes[j].y), 2));
				}
			}
		}
	}
	
	static class Node{
		long x;
		long y;
		public Node(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
