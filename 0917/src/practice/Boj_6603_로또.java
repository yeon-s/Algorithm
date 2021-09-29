package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6603_로또 {

	static boolean[] isSelected;
	static int[] result;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) {
				break;
			}else {
				StringTokenizer st =new StringTokenizer(str);
				int k = Integer.parseInt(st.nextToken());
				
				arr = new int[k];
				for(int i=0;i<k;i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				
				isSelected = new boolean[k];
				result = new int[6];
				comb(0,0,k);
			}
			System.out.println();
			
		}

	}

	static void comb(int target,int cnt,int k) {
		if(cnt==6) {
			for(int i=0;i<6;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(target ==k) {
			return;
		}
		
		isSelected[target] = true;
		result[cnt] = arr[target];
		comb(target+1,cnt+1,k);
		isSelected[target] =false;
		comb(target+1,cnt,k);
	}
}
