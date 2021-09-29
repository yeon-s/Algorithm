package practice;

import java.util.Arrays;

public class Test03_combination {
	static int N=4,R=2;
	static String[] cards = {"A","B","C","D"};
	static boolean[] select = new boolean[cards.length];
	
	public static void main(String[] args) {
		comb(0,0);
	}

	static void comb(int target,int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(select));
			return;
		}
		if(target==N) {
			return;
		}
		
		select[target] = true;
		comb(target+1,cnt+1);
		select[target] = false;
		comb(target+1,cnt);
	}
}
