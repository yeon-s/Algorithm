package com.ssafy.io;

public class IO_StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello ");
		sb.append("SSAFY!!");
		sb.setLength(sb.length()-2);
		System.out.println(sb.toString());
	}

}
