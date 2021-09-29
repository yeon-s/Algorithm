package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_괄호짝_Stack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String open="[{(<";
		String close="]})>";
		
		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> stack = new Stack<>();
				
			int len = Integer.parseInt(br.readLine());
			String line = br.readLine();
			int ans = 1; // 기본적으로 전체 유효하다 해놓고 하나라도 어긋나면 유효하지 않음으로 처리.
			for (int i = 0; i < len; i++) {
				char ch = line.charAt(i);
				if(open.contains(ch+"")) { // 열리는 괄호
					stack.push(ch);
				}else { // 닫히는 괄호
					if(stack.isEmpty() || open.indexOf(stack.peek()+"") != close.indexOf(ch+"")) {
						ans = 0;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty())
				ans = 0;
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}






