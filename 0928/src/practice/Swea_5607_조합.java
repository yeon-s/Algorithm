package practice;

import java.util.Scanner;

public class Swea_5607_조합 {

	static int p = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			
			long[] fact = new long[N+1];
			fact[0] = 1;
			
			for(int i=1;i<=N;i++) {
				fact[i] = (fact[i-1]*i)%p;
			}
			
			//nCr = n! * 1/(n-r)! * 1/r!이므로
			long nam = (fact[N]*pow(fact[N-R],p-2))%p;		// 1/(n-r)!을 p-2제곱 정수로 만들기
			nam = (nam * pow(fact[R],p-2))%p;			// 1/r!을 p-2제곱 정수로 만들기
			System.out.println("#"+tc+" "+nam);
		}

	}

	static long pow(long a,long b) {
		if(b==1) {
			return a;
		}
		
		long temp =0;
		if(b%2==0) {
			temp = pow(a,b/2)%p;
			return (temp*temp)%p;
		}else {
			temp = pow(a,b/2)%p;
			return (((temp*temp)%p)*a)%p;
		}
	}
}
