package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_괄호짝_array {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String open="[{(<";
		String close="]})>";
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			char[] stack = new char[len]; 	
			String line = br.readLine();

			int ans = 1; // 기본적으로 전체 유효하다 해놓고 하나라도 어긋나면 유효하지 않음으로 처리.
			int top = 0;
			for (int i = 0; i < len; i++) {
				char ch = line.charAt(i);
				if(open.contains(ch+"")) { // 열리는 괄호
					stack[top] = ch;
					top++;
				}else { // 닫히는 괄호
					if(top==0 || open.indexOf(stack[top-1]+"") != close.indexOf(ch+"")) {
						ans = 0;
						break;
					}
					top--;
				}
			}
			if(top>0)
				ans = 0;
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
