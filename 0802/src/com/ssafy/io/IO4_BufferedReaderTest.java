package com.ssafy.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO4_BufferedReaderTest {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���? :");
		int no = Integer.parseInt(br.readLine());
		System.out.println("�츮�� �Ѹ���� ǥ���ϸ�? :");
		String msg = br.readLine();
		System.out.println(no+":"+msg);
	}

} 
