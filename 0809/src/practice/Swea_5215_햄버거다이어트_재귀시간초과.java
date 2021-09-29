package practice;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Swea_5215_햄버거다이어트_재귀시간초과 {
	
	static int N;
	static int L;
	static boolean[] isSelected;
	static List<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			list = new ArrayList<>();
			Ingredient[] arr = new Ingredient[N];
			isSelected = new boolean[N];
			for(int i=0;i<N;i++) {
				arr[i]=new Ingredient(sc.nextInt(), sc.nextInt());
			}
			//입력 끝
			
			generateSubset(0, arr);
			int max=0;
			for(int i=0;i<list.size();i++) {
				max = Math.max(max, list.get(i));
			}
			System.out.println("#"+tc+" "+max);
		}

	}
	
	private static void generateSubset(int cnt,Ingredient[] arr) {
		if(cnt==N) {
			//부분집합 완성
			int sum=0;
			int sumScore=0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					sum = sum+arr[i].k;
					sumScore +=arr[i].score;
				}	
			}
			if(sum<=L) {
				list.add(sumScore);				
			}
			return;
		}
		
		isSelected[cnt]=true;
		generateSubset(cnt+1,arr);
		isSelected[cnt]=false;
		generateSubset(cnt+1,arr);
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

