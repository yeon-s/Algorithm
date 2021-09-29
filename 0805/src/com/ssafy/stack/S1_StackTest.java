package com.ssafy.stack;

import java.util.Stack;

public class S1_StackTest {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		System.out.println(stack.isEmpty()+"/"+stack.size());
		
		stack.push("오서연");
		stack.push("김수빈");
		stack.push("심으뜸");
		
		System.out.println(stack.isEmpty()+"/"+stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		if(!stack.isEmpty()) {
			System.out.println(stack.pop());			
		}
		
	}

}
