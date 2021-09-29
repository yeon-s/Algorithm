package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jungol_1828_냉장고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Bac[] bacteria = new Bac[N];
		
		for(int i=0;i<N;i++) {
			bacteria[i] = new Bac(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(bacteria);
		
		ArrayList<Bac> list = new ArrayList<>();
		list.add(bacteria[0]);
		
		for(int i=0;i<N;i++) {
			if(bacteria[i].min>list.get(list.size()-1).max) {
				list.add(bacteria[i]);
			}
		}
		System.out.println(list.size());
		
	}

	
	static class Bac implements Comparable<Bac>{
		int min;
		int max;
		public Bac(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		
		@Override
		public int compareTo(Bac o) {
			int value = this.max-o.max;
			
			if(value!=0) {
				return value;
			}
			return this.min-o.min;
		}
	
	}
}
