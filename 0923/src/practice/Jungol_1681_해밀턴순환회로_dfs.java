package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_1681_해밀턴순환회로_dfs {

	static int N;
	static int[][] adjMatrix;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		boolean[] visited = new boolean[N];
		min= 10000;
		dfs(0,visited,0,0);
		
		System.out.println(min);
	}

	
	
	static void dfs(int current,boolean[] visited,int sum,int depth) {
		if(sum>min) {
			return;
		}
		
		visited[current] = true;
		
		if(depth==N-1) {
			if(adjMatrix[current][0]==0) {
				return;
			}
			
			int last = sum+adjMatrix[current][0];
			min = Math.min(min, last);
			return;
		}
		
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && adjMatrix[current][i] !=0) {
				dfs(i,visited,sum+adjMatrix[current][i],depth+1);
				visited[i] = false;
			}
		}
		
	}
}
