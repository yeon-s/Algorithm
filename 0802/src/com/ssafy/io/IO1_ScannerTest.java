package com.ssafy.io;

import java.util.Scanner;

public class IO1_ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����,�Ǽ�,���ڿ��� ���ʷ� �Է��ϼ��� : ");
		
		System.out.print("���� ���� : "+sc.nextInt());
		System.out.print("���� �Ǽ� : "+sc.nextDouble());
		System.out.print("���� ���ڿ� : "+sc.next());
		System.out.print("���� ���ڿ� : "+sc.nextLine()+"!!");
	}

}
