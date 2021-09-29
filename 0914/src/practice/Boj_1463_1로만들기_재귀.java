package practice;

import java.util.Scanner;

public class Boj_1463_1로만들기_재귀 {

	static int[] memo;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		memo = new int[N+1];
		System.out.println(dfs(N));
	}

	static int dfs(int num) {
		if(num==1) {
			return 0;
		}
		
		if(memo[num]==0) {
			int tmp3 = Integer.MAX_VALUE;
			int tmp2 = Integer.MAX_VALUE;
			int tmp1 = Integer.MAX_VALUE;
			if(num%3==0) {
				tmp3 = dfs(num/3)+1;
			}
			if(num%2==0) {
				tmp2 = dfs(num/2)+1;
			}
			tmp1 = dfs(num-1)+1;
			memo[num] = Math.min(tmp3, tmp2);
			memo[num] = Math.min(memo[num],tmp1);
		}
		
		return memo[num];
	}
}
