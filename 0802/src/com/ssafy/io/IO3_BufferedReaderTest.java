package com.ssafy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IO3_BufferedReaderTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		char [] ch = str.toCharArray();
//		for(char c : ch) {
//			System.out.println(c);
//		}
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		while(n-->0) {
			int value = Integer.parseInt(st.nextToken());
			System.out.println(value);
		}
	}

}
