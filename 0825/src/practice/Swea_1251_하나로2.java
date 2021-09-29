package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1251_하나로2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			
			Node[] nodes = new Node[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer str = new StringTokenizer(br.readLine());
				
			
			for(int i=0;i<N;i++) {
				nodes[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(str.nextToken()));
				
			}
			
			double E = Double.parseDouble(br.readLine());
			//입력 끝
			
			long minResult = Long.MAX_VALUE;
			for(int n=0;n<N;n++) {
				
				boolean[] visited = new boolean[N];
				long[] minEdge = new long[N];  
				double result = 0;
				
				for(int i=0;i<N;i++) {
					
					minEdge[i]=Long.MAX_VALUE;
				}
				minEdge[n] = 0;
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
				minResult = Math.min(minResult, (long)result);
			}
			System.out.println("#"+tc+" "+(long)minResult);
			
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
