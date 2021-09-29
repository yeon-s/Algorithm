package practice;

import java.util.Arrays;

public class Test01_permutation {
	static int N=4, R=2;
	static String[] cards = {"A","B","C","D"};
	static String[] result = new String[R];
	static boolean[] used = new boolean[N];

	public static void main(String[] args) {
		perm(0);
	}
	
	static void perm(int target) {
		if(target==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=0;i<N;i++) {
			if(used[i]) {
				continue;
			}
			result[target] = cards[i];
			used[i]=true;
			perm(target+1);
			used[i] =false;
		}
	}
}
