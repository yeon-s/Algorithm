package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Swea_1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int num = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			Stack<String> stack = new Stack<>();
			boolean flag = true;
			
			for(int i=0;i<num;i++) {
				String slap =str.substring(i, i+1);
				if(slap.equals("(") || slap.equals("[") || slap.equals("") || slap.equals("<")) {
					stack.push(slap);
				}else if(!stack.isEmpty()){
					if(slap.equals(stack.pop())) {
						continue;
					}else {
						flag = false;
						break;
					}
				}
			}
			if(!stack.isEmpty()) {
				flag = false;
			}
			
			if(flag) {
				System.out.println("#"+tc+" "+"1");
			}else {
				System.out.println("#"+tc+" "+"0");
			}
			
		}

	}

}
