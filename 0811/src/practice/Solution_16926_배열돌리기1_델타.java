package practice;

import java.util.Scanner;

public class Solution_16926_배열돌리기1_델타 {
	static int N, M, R;
	static int[][] map;

	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int r = 0; r < R; r++) {
			rotate();

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void rotate() {
		for (int t = 0; t < Math.min(N, M) / 2; t++) {
			int tmp = map[t][t];
			int nowi = t, nowj = t;
			int dir = 0; // 일단 내 옆칸을 오른쪽 칸으로 계산하는 0번 방향
			
			while (true) {
				int nexti = nowi + di[dir];
				int nextj = nowj + dj[dir];
				if(nextj<M-t && nexti < N-t && nextj >= t && nexti >= t) {
					map[nowi][nowj] = map[nexti][nextj];
					nowi = nexti;
					nowj = nextj;
				}else { // 내 옆칸 nexti, nextj가 유효하지 않으면 방향 틀어서 옆칸 다시 계산해야함.
					dir++;
				}
				if(dir==4)
					break;
			}
			map[t+1][t] = tmp;
		}
	}
}
