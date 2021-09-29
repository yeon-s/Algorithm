package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1251_하나로4_성공 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=TC;tc++) {
			int N = Integer.parseInt(br.readLine());
			Node[] arr = new Node[N];
			StringTokenizer x = new StringTokenizer(br.readLine());
			StringTokenizer y = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(br.readLine());
			
			for(int i=0;i<N;i++) {
				arr[i] = new Node(Integer.parseInt(x.nextToken()), Integer.parseInt(y.nextToken()));
			}
			//입력 끝
			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];
			for(int i=0;i<N;i++) {
				minEdge[i] = Double.MAX_VALUE;
			}
			
			double result = 0;
			minEdge[0]=0;
			
			for(int i=0;i<N;i++) {
				double min = Double.MAX_VALUE;	//현재 민엣지 중 최소비용 찾기
				int minVertex = -1;				//현재 최소비용 가진 정점 담을 변수
				for(int j=0;j<N;j++) {
					if(!visited[j] && min>minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}
				
				result +=min;
				visited[minVertex] = true;
				
				for(int j=0;j<N;j++) {
					if(!visited[j] && minEdge[j] > (Math.pow(Math.abs(arr[minVertex].x-arr[j].x), 2) + Math.pow(Math.abs(arr[minVertex].y-arr[j].y), 2))) {
						minEdge[j] = (Math.pow(Math.abs(arr[minVertex].x-arr[j].x), 2) + Math.pow(Math.abs(arr[minVertex].y-arr[j].y), 2));
						//minEdge[j] = Math.abs(arr[minVertex].x-arr[j].x)<<2 + Math.abs(arr[minVertex].y-arr[j].y)<<2;
					}
				}
			}
			System.out.println("#"+tc+" "+Math.round(E*result));
		}
		

	}

	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
