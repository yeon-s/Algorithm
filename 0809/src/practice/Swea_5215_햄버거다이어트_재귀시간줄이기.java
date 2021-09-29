package practice;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Swea_5215_햄버거다이어트_재귀시간줄이기 {
	
	static int N;
	static int L;
	static boolean[] isSelected;
	static int max;
	static Ingredient[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new Ingredient[N];
			isSelected = new boolean[N];
			for(int i=0;i<N;i++) {
				arr[i]=new Ingredient(sc.nextInt(), sc.nextInt());
			}
			//입력 끝
			
			max=0;
			generateSubset(0,0,0);
			System.out.println("#"+tc+" "+max);
		}

	}
	
	private static void generateSubset(int cnt,int sum, int sumScore) {
		if(sum>L) {
			return;
		}
		if(cnt==N) {
			//부분집합 완성
			max = Math.max(max, sumScore);		
			return;
		}
		
		isSelected[cnt]=true;
		generateSubset(cnt+1,sum+arr[cnt].k,sumScore+arr[cnt].score);
		isSelected[cnt]=false;
		generateSubset(cnt+1,sum,sumScore);
	}
	
	
	static class Ingredient{
		int score;
		int k;
		
		public Ingredient(int score, int k) {
			super();
			this.score = score;
			this.k = k;
		}
		
		
	}
}

