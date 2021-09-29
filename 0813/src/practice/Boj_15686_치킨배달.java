package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15686_치킨배달 {

	static int N,M;
	static boolean[] isSelected= new boolean[13]; 
	static Chicken[] chickens;
	static House[] houses;
	static int chickCount;
	static int houseCount;
	static int min;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st2.nextToken());
			}
		}
		//입력 끝
		
		//치킨집 위치구하기
		//리스트는 메모리 많이 쓸거같은데 배열로할까 리스트로 할까
		chickens = new Chicken[13];
		int index = 0;
		chickCount =0;		//치킨집 개수
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==2) {
					chickens[index++] = new Chicken(i, j);
					chickCount++;
				}
			}
		}
		//집 위치 구하기
		houses = new House[2*N];
		int index2=0;
		houseCount =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					houses[index2++] = new House(i, j);
					houseCount++;
				}
			}
		}
		//치킨집 뽑기
		result = Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(result);
		

	}
	
	static void comb(int target,int cnt) {
		if(cnt==M) {
			int sum=0;
			for(int i=0;i<houseCount;i++) {
				min = Integer.MAX_VALUE;
				for(int j=0;j<chickCount;j++) {
					if(isSelected[j]) {
						int y = Math.abs(houses[i].y-chickens[j].y);
						int x = Math.abs(houses[i].x-chickens[j].x);
						min = Math.min(min, x+y);
					}
				}
				sum +=min;
			}
			result = Math.min(result, sum);
			
			
			return;
		}
		if(target==chickCount) {
			return;
		}
		
		isSelected[target] = true;
		comb(target+1,cnt+1);
		isSelected[target]= false;
		comb(target+1,cnt);
		
	}
	
	
	
	static class Chicken {
		int y;
		int x;
		public Chicken(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	static class House {
		int y;
		int x;
		public House(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
