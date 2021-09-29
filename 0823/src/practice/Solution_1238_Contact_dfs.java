package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1238_Contact_dfs {
	static int maxTime;
	static int ans; // 마지막에 연락받은 학생 번호
	static boolean[][] arr;
	static int[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10;
		
		for(int tc=1; tc<=TC; tc++) {
			arr = new boolean[101][101];
			visit = new int[101]; // 연락받은 시간 기록해놓기.(혹시 더 빨리 연락받는 경우에는 갱신해야함.)
			
			Arrays.fill(visit, Integer.MAX_VALUE);
			
			int len = sc.nextInt();
			int start = sc.nextInt();
			
			for(int i=0; i<len/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				arr[from][to] = true;
			}
			ans = maxTime = -1;
			dfs(start, 0);
			
			for(int i=1; i<=100; i++) {
				if(visit[i]!=Integer.MAX_VALUE && maxTime <= visit[i]) { // 확실히 기존보다 늦게 연락받았으면 ans 갱신
					maxTime = visit[i];
					ans = i;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	static void dfs(int now, int time) {
		visit[now] = time;
		
		for(int i=1; i<=100; i++) {
			if(arr[now][i] && time+1<visit[i]) {
				dfs(i,time+1);
			}
		}
	}
}
