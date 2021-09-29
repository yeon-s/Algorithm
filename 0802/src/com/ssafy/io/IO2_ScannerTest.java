package com.ssafy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IO2_ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		System.out.println("기수? :");
		int no = sc.nextInt();
		System.out.println("우리를 한마디로 표현하면? :");
		//String msg = sc.next();
		sc.nextLine();
		String msg = sc.nextLine();
		System.out.println(no+":"+msg);
	}

}
