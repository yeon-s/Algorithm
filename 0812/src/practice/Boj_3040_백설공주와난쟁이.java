package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3040_백설공주와난쟁이 {
	static int N=9,R=7;
	static int[] arr= new int[N]; 
	static boolean[] isSelected = new boolean[N];
	static int[] result = new int[R];
	static int index;
	static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//입력 끝
		comb(0,0,0);
		for(int i=0;i<R;i++) {
			System.out.println(result[i]);
		}
	}
	
	static void comb(int target, int cnt,int sum) {
		if(flag) {
			return;
		}
		if(sum>100) {
			return;
		}
		if(cnt==R) {
			if(sum==100) {
				for(int i=0;i<N;i++) {
					if(isSelected[i]) {
						result[index++]= arr[i];
					}
				}
				flag = true;
			}
			return;
		}
		if(target==N) {
			return;
		}
		
		
		isSelected[target] = true;
		comb(target+1,cnt+1,sum+arr[target]);
		isSelected[target] = false;
		comb(target+1,cnt,sum);
	}
}
