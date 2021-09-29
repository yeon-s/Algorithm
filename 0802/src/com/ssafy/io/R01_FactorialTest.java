package com.ssafy.io;

public class R01_FactorialTest {

	private static int factorial0(int n) {
		int num=1;
		for(int i=n;i>0;i--) {
			num = num*i;
		}
		return num;
	}
	
	private static int num=1;
	private static void factorial1(int i) {
		if(i==0) {
			return;
		}
		num=num*i;
		factorial1(i-1);
	}
	
	private static int factorial(int n) {
		
		if(n<=1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial0(5));
		factorial1(5);
		System.out.println(num);
	}

}
