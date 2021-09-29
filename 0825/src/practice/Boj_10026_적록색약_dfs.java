package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10026_적록색약_dfs {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int result;
	static boolean flag =false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.substring(j,j+1).charAt(0);
			}
		}
		//입력 끝
		
		//일반인일때
		visited = new boolean[N][N];
		result = 0;
		dfs(0,0);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					flag =false;
					dfs(i,j);
				}
			}
		}
		System.out.print(result+" ");
		
		//적록색약일때
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='R') {
					map[i][j]='G';
				}
			}
		}
		visited = new boolean[N][N];
		result = 0;
		flag=false;			//플래그가 현재 true니까 false로
		dfs(0,0);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					flag =false;
					dfs(i,j);
				}
			}
		}
		System.out.println(result);
	}

	static void dfs(int nowi,int nowj) {
		//네방향 탐색(배열범위 안넘어가고 visited false면)
		//똑같으면 나아감
		//갈데 없으면 리턴
		visited[nowi][nowj]=true;
		
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			if(nexti>=N || nexti<0 || nextj>=N || nextj<0) {
				continue;
			}
			if(!visited[nexti][nextj] && map[nexti][nextj]==map[nowi][nowj]) {
				dfs(nexti,nextj);				
			}
		}
		if(flag) {
			return;
		}
		result = result+1;
		flag = true;
		
	}
	

}
