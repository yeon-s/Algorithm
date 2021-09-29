package practice;

import java.util.Scanner;


public class Boj_2961_도영이음식 {

	static int N;
	static Ingredient[] arr;
	static boolean[] isSelected;
	static int min= Integer.MAX_VALUE;
	static int diff;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new Ingredient[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = new Ingredient(sc.nextInt(), sc.nextInt());
		}
		//입력 끝
		isSelected = new boolean[N];
		subset(0,1,0);
		System.out.println(min);
	}
	
	static void subset(int target, int sinScore, int sseunScore) {
		if(target==N) {
			if(sinScore==1 && sseunScore==0) {
				return;
			}
			if(sinScore>sseunScore) {
				diff = sinScore-sseunScore;				
			}else {
				diff = sseunScore-sinScore;
			}
			min = Math.min(min, diff);
			
			return;
		}
		
		
		
		isSelected[target] = true;
		subset(target+1,sinScore*arr[target].sin,sseunScore+arr[target].sseun);
		isSelected[target] = false;
		subset(target+1,sinScore,sseunScore);
		
	}
	
	
	static class Ingredient{
		int sin;
		int sseun;
		
		public Ingredient(int sin, int sseun) {
			super();
			this.sin = sin;
			this.sseun = sseun;
		}
		
		
	}
}
