package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringBuilder sb = new StringBuilder();
			int num = Integer.parseInt(br.readLine());
			String[] str = new String[num];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<num;i++) {
				str[i] = st.nextToken();
			}
			//입력 끝
			
			Stack<String> one = new Stack<>();
			Stack<String> two = new Stack<>();
			Stack<String> result = new Stack<>();
			
			for(int i=0;i<(num+1)/2;i++) {
				one.push(str[i]);
			}
			for(int i=(num+1)/2;i<num;i++) {
				two.push(str[i]);
			}
			if(num%2==1) {
				result.push(one.pop());
			}
			for(int i=0;i<num/2;i++) {
				result.push(two.pop());
				result.push(one.pop());
			}
			for(int i=0;i<num;i++) {
				sb.append(result.pop()+" ");
			}
			
			System.out.println("#"+tc+" "+sb);
		}
	}

}
