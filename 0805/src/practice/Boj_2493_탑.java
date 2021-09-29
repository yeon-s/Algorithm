package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		int[] output= new int[N];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		for(int i=0;i<N;i++) {
			Stack<Integer> stack = new Stack<>();
			
			for(int j=0;j<arr.length-i;j++) {
				stack.push(arr[j]);
			}
			int num=stack.pop();
			if(stack.isEmpty()) {
				result[N-i-1]=0;
				break;
			}
			
			for(int j=0;j<N-i-1;j++) {
				int next = stack.pop();
				if(next>=num) {
					result[N-i-1]=next;
					break;
				}
				if(stack.isEmpty()) {
					result[N-i-1]=0;
					break;
				}
				continue;
			}
		}
		for(int i=0;i<N;i++) {
			if(result[i]==0) {
				output[i]=0;
			}else {
				for(int j=0;j<N;j++) {
					if(result[i]==arr[j]) {
						output[i]=j+1;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(output[i]+" ");
		}
	}

}
