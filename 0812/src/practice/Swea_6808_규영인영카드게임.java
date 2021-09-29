package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_6808_규영인영카드게임 {

	static int[] ky;
	static int[] iy;
	static int kyScore;
	static int iyScore;
	static int win;
	static int lose;
	static boolean[] used = new boolean[9];
	static int[] numbers= new int[9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			ky = new int[9];
			int[] arr = new int[19];
			for(int i=0;i<9;i++) {
				ky[i] = sc.nextInt();
				arr[ky[i]]=1;
			}
			//입력 끝
			iy =new int[9];
			//인영 카드 구하기
			int num=0;
			for(int i=1;i<=18;i++) {
				if(arr[i]==0) {
					iy[num++] = i;
				}
			}
			win=0;
			lose=0;
			perm(0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}

	}
	
	
	static void perm(int cnt) {
		if(cnt==9) {
			kyScore =0;
			iyScore = 0;
			for(int i=0;i<9;i++) {
				if(ky[i]>numbers[i]) {
					kyScore += ky[i]+numbers[i];
				}else {
					iyScore += ky[i]+numbers[i];
				}
			}
			if(kyScore>iyScore) {
				win++;
			}else if(kyScore<iyScore) {
				lose++;
			}
			return;
		}
		
		
		for(int i=0;i<9;i++) {
			if(used[i]) {
				continue;
			}
			numbers[cnt] = iy[i];
			used[i]=true;
			perm(cnt+1);
			used[i]=false;
			
			
		}
		
		
	}
}
