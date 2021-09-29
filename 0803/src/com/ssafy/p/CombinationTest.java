package com.ssafy.p;

import java.util.Arrays;

//N개의 서로 다른 수 R개 뽑는 조합	
public class CombinationTest {

	
	static int N=3, R=2;
	static int[] input;
	static int[] numbers;
	
	public static void main(String[] args) {
		
		input = new int[] {1,4,7};
		numbers = new int[R]; 
		
		
		combination(0,0);
	}
	
	private static void combination(int cnt,int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//start 위치의 수부터 가능한 수 모두 고려
		for(int i=start;i<N;i++) {		//i:index
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
			
		}
	}

}
