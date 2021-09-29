package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Swea_1218_괄호짝2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int size = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			char[] ch = str.toCharArray();
			Stack<Character> stack = new Stack<>();
			
			String open = "[{(<";
			String close = "]})>";
			
			
			for(int i=0,num=str.length();i<num;i++) {
				
				if(open.contains(ch[i]+"")){
					stack.push(ch[i]);
				}else if(!stack.isEmpty()){
					
					int index = open.indexOf(stack.peek());
					if(ch[i]==close.charAt(index)) {
						stack.pop();						
					}else {
						break;
					}
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("#"+tc+" "+"1");
			}else {
				System.out.println("#"+tc+" "+"0");
			}
			
		}
		
	}

}
