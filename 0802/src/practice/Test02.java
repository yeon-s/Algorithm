package practice;

import java.util.Arrays;

public class Test02 {
	
	static int[] numbers = {6,7,8};
	static int[] result = new int[numbers.length];
	static boolean[] used = new boolean[numbers.length];
	
	public static void main(String[] args) {
		make(0);
		}
	
	static void make(int idx) {
		if(idx==3) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=0;i<numbers.length;i++) {
			result[idx] = numbers[i];
			make(idx+1);
		}
	}

}
