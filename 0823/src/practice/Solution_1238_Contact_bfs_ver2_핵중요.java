package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1238_Contact_bfs_ver2_핵중요 {
	static int maxTime;
	static int ans; // 마지막에 연락받은 학생 번호
	static boolean[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = 10;

		for (int tc = 1; tc <= TC; tc++) {
			arr = new boolean[101][101];

			int len = sc.nextInt();
			int start = sc.nextInt();

			for (int i = 0; i < len / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				arr[from][to] = true;
			}
			ans = maxTime = -1;

			bfs(start);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>(); // 스케줄표
		visit = new boolean[101];
		
		visit[start] = true; // 공중전화 사용 예약에 이름 올라간적 있나 없나.
		queue.add(start);

		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size(); // 현재 스케줄 예약이 몇명 있나 보자.

			int tmp = 0; // 요번 시간에 연락받는 애들중 번호 큰애 찾자(시간은 어차피 동일한 애들임.)
			for(int s=0; s<size; s++) {
				int now = queue.poll();
				
				if(tmp < now)
					tmp = now;
				
				for (int i = 1; i <= 100; i++) {
					if (arr[now][i] && !visit[i]) {
						queue.add(i);
						visit[i] = true;
					}
				}
			} // for size
			ans = tmp;
			time++;			
		}
	}
}





