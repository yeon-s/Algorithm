package practice;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_3234_준환이양팔저울2 {

	static int N;
	static int[] arr;
	static boolean[] isSelected;
	static boolean[] isSelected2;
	static int[] result;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//입력 끝
			isSelected = new boolean[N];
			isSelected2 = new boolean[N];
			result = new int[N];
			count=0;
			int sum=0;
			for(int i=0;i<N;i++) {
				sum +=arr[i];
			}
			subset(0,sum,0);
			System.out.println("#"+tc+" "+count);
		}
		
		
	}

	static void perm(int cnt,int left,int right) {
		if(right>left) {
			return;
		}
		if(cnt==N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected2[i]) {
				continue;
			}
			result[cnt] = arr[i];
			isSelected2[i]=true;
			perm(cnt+1,left+arr[i],right);
			perm(cnt+1,left,right+arr[i]);
			isSelected2[i]=false;
		}
	}
	
	static void subset(int cnt,int sum,int left) {	
		if(cnt==N) {
			if(left<sum-left) {
				return;
			}else {
				
			}
		}
		
		isSelected[cnt]=true;
		subset(cnt+1,sum,left+arr[cnt]);
		isSelected[cnt]=false;
		subset(cnt+1,sum,left);
	}
}
