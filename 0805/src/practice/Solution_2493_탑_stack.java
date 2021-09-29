package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2493_탑_stack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
	
		Stack<Tower> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()); // 탑의 높이가 공백으로 구분되어 입력됨.
		for(int num=1; num<=N; num++) { // num은 탑의 번호임. 총 N개의 탑이 입장함.
			int height = Integer.parseInt(st.nextToken()); // 지금 입장하는 탑의 높이
			
			while(!stack.isEmpty() && stack.peek().height <= height) { // 내 레이저를 수신하지 못하는 놈들 다 나와.
				stack.pop();
			}
			
			if(stack.isEmpty()) // 나보다 작은놈들 뺐더니 아무도 안남았어... 아무도 내 레이저를 받지않아 ...... ㅠㅠ
				sb.append("0 ");
			else
				sb.append(stack.peek().num+" ");
			
			stack.push(new Tower(height, num));
		}
		System.out.println(sb.toString());
	}
	
	static class Tower{
		int height; // 탑의 높이
		int num; // 탑의 번호
		
		Tower(int h, int n){
			height = h;
			num = n;
		}
	}
}
