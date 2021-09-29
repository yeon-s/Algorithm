package practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2493_탑2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i=0,size=arr.length;i<size;i++) {
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
					for(int k=0;k<N;k++) {
						if(arr[k]==next) {
							result[N-i-1]=k+1;
						}
					}
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
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
