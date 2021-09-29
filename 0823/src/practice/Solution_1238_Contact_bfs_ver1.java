package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1238_Contact_bfs_ver1 {
	static int maxTime;
	static int ans; // 마지막에 연락받은 학생 번호
	static boolean[][] arr;
	static int[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = 10;
		
		for(int tc=1; tc<=TC; tc++) {
			arr = new boolean[101][101];
			visit = new int[101];
			Arrays.fill(visit, Integer.MAX_VALUE);
			
			int len = sc.nextInt();
			int start = sc.nextInt();
			
			for(int i=0; i<len/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				arr[from][to] = true;
			}
			ans = maxTime = -1;
			
			bfs(start);
			
			for(int i=1; i<=100; i++) {
				if(visit[i]!=Integer.MAX_VALUE && maxTime <= visit[i]) { // 확실히 기존보다 늦게 연락받았으면 ans 갱신
					maxTime = visit[i];
					ans = i;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void bfs(int start) {
		Queue<Student> queue = new LinkedList<>();
		visit[start] = 0; // 맨 처음 연락 돌리기 시작하는 애는 시간 0분
		queue.add(new Student(start, 0));
		
		while(!queue.isEmpty()) {
			Student now = queue.poll(); // 현재 공중전화 쓰는 사람이 num 학생임.
			
			for(int i=1; i<=100; i++) {
				if(arr[now.num][i] && visit[i]==Integer.MAX_VALUE) {
					visit[i] = now.time+1;
					queue.add(new Student(i, now.time+1));
				}
			}
		}
	}

	static class Student{
		int num;
		int time;
		
		Student(int num, int time){
			this.num = num;
			this.time = time;
		}
	}
}
