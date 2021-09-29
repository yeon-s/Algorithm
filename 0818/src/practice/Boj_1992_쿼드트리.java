package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1992_쿼드트리 {

	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		//입력 끝
		sb = new StringBuilder();
		divide(N, 0, N, 0, N);
		System.out.println(sb);
	}

	
	static void divide(int n,int si,int ei,int sj,int ej) {
		boolean flag=true;
		int mid = n/2;
		//기저
		if(n==1) {
			sb.append(map[si][sj]+"");
			return;
		}
		
		Loop1:
		for(int i=si;i<ei;i++) {
			for(int j=sj;j<ej;j++) {
				if(map[si][sj]==0 && map[i][j]==1) {
					flag = false;
					break Loop1;
				}else if(map[si][sj]==1 && map[i][j]==0) {
					flag = false;
					break Loop1;
				}
				
			}
		}
		
		if(!flag) {
			sb.append("(");
			divide(n/2,si,ei-mid,sj,ej-mid); 	//왼위
			divide(n/2,si,ei-mid,sj+mid,ej);	//오위
			divide(n/2,si+mid,ei,sj,ej-mid);	//왼아
			divide(n/2,si+mid,ei,sj+mid,ej);	//오아
			sb.append(")");
		}else {
			//문자추가
			if(map[si][sj]==0) {
				sb.append("0");	
				return;
			}else if(map[si][sj]==1) {
				sb.append("1");
				return;
			}
		}
	}
}
