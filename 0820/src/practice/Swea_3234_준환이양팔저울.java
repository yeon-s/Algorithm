package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea_3234_준환이양팔저울 {

	static int N;
	static int[] arr;
	static boolean[] isSelected;
	static int[] result;
	static int count;
	static int sum;
	static int[] factorial;
	static int[] pow;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		factorial = new int[10];
		factorial[0]=1;
		for(int i=1;i<10;i++) {
			factorial[i]= factorial[i-1]*i;
		}
		pow = new int[10];
		pow[0]=1;
		for(int i=1;i<10;i++) {
			pow[i]=2*pow[i-1];
		}
		
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
			result = new int[N];
			count=0;
			sum=0;
			for(int i=0;i<N;i++) {
				sum +=arr[i];
			}
			
			
			perm(0,0,0,sum);
//			sb.append("#").append(tc).append(" ").append(count).append("\n");
			System.out.println("#"+tc+" "+count);
		}
//		sb.setLength(sb.length()-1);
//		System.out.println(sb);
		
	}

	static void perm(int cnt,int right,int left,int sum) {
		if(right>left) {
			return;
		}
		
		if(left>=sum-left) {
			count +=pow(N-cnt)*factorial(N-cnt);
			return;
		}
		if(cnt==N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) {
				continue;
			}
			result[cnt] = arr[i];
			isSelected[i]=true;
			perm(cnt+1,right,left+arr[i],sum);
			perm(cnt+1,right+arr[i],left,sum);
			isSelected[i]=false;
		}
	}
	static int factorial(int n) {
		if(n<=1) {
			return 1;
		}
		return n* factorial(n-1);
	}
	static int pow(int n) {
		int result = 1;
		for(int i=0;i<n;i++) {
			result *= 2;
		}
		return result;
	}
}
