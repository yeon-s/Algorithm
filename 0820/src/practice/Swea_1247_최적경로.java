package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1247_최적경로 {

	static int N; 
	static int[][] map;
	static Posi[] arr;
	static Posi company;
	static Posi home;
	static boolean[] isSelected;
	static Posi[] result;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[101][101];
			arr = new Posi[N];
			isSelected = new boolean[N];
			result = new Posi[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i=0;i<N;i++) {
				arr[i] = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}			
			//입력 끝
			min = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#"+tc+" "+min);
		}
	}

	static void perm(int cnt) {
		if(cnt==N) {
			int sum=0;
			sum += Math.abs(company.x-result[0].x)+Math.abs(company.y-result[0].y);
			for(int i=0;i<N-1;i++) {
				sum += Math.abs(result[i].x-result[i+1].x)+Math.abs(result[i].y-result[i+1].y);
			}
			sum += Math.abs(home.x-result[N-1].x)+Math.abs(home.y-result[N-1].y);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			result[cnt]=arr[i];
			isSelected[i]=true;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}
	
	static class Posi{
		int y;
		int x;
		public Posi(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
