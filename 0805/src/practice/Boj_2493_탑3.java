package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2493_탑3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		stack.push(arr[0]);
		index.push(1);
		sb.append("0 ");
		
		for(int i=1;i<N;i++) {
			int height = arr[i];
			
			while(!stack.isEmpty() && stack.peek()<height) {
				stack.pop();
				index.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}else {
				sb.append(index.peek()+"").append(" ");
			}
			stack.push(arr[i]);
			index.push(i+1);
		}
		
		System.out.println(sb);
		

	}

}
