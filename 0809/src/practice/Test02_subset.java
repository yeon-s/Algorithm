package practice;

import java.util.Arrays;

public class Test02_subset {

	static String[] cards = {"A","B","C","D"};
	static boolean[] select = new boolean[cards.length];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subset(0);
	}

	
	static void subset(int target) {
		if(target==select.length) {
			System.out.println(Arrays.toString(select));
			return;
		}
		select[target]=true;
		subset(target+1);
		select[target]=false;
		subset(target+1);
	}
}
