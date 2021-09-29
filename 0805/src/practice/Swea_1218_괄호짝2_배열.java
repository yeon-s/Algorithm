package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Swea_1218_괄호짝2_배열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int size = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			char[] ch = str.toCharArray();
			String[] stack = new String[size];
			int top=0;
			
			String open = "[{(<";
			String close = "]})>";
			
			
			for(int i=0,num=str.length();i<num;i++) {
				
				if(open.contains(ch[i]+"")){
					stack[top]=(ch[i]+"");
					top++;
				}else if(stack[0]!=null){		//스택배열이 비어있지 않다면
					
					int index = open.indexOf(stack[top-1]);
					if(ch[i]==close.charAt(index)) {
						stack[top-1]=null;
						top--;
					}else {
						break;
					}
				}
			}
			
			if(stack[0]==null) {
				System.out.println("#"+tc+" "+"1");
			}else {
				System.out.println("#"+tc+" "+"0");
			}
			
		}
		
	}

}
