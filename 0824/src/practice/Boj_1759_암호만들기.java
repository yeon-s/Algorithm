package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759_암호만들기 {

	static int L,C;
	static char[] arr;
	static boolean[] isSelected;
	static char[] result;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		result = new char[L];
		sb = new StringBuilder();
		for(int i=0;i<C;i++) {
			isSelected = new boolean[C];
			isSelected[i]=true;
			result[0]=arr[i];
			perm(1,arr[i]);
		}
		System.out.println(sb);
		
	}

	static void perm(int cnt, char a) {
		
		if(cnt==L) {
			String moeum="aeiou";
			int janum=0;
			int monum=0;
			for(int i=0;i<L;i++) {
				sb.append(result[i]);
				if(moeum.contains(result[i]+"")) {
					monum++;
				}else {
					janum++;
				}
			}
			if(monum>=1 && janum>=2) {
				sb.append("\n");
			}else {
				sb.setLength(sb.length()-L);
			}
			
			return;
		}
		
		int before = (int)a;
		for(int i=0;i<C;i++) {
			if(isSelected[i] || before>=(int)arr[i]) {
				continue;
			}
			result[cnt]=arr[i];
			isSelected[i]=true;
			perm(cnt+1,arr[i]);
			isSelected[i]=false;
		}
	}
}
