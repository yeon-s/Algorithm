package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_9229_한빈이와스팟마트_재귀시간초과 {

	static int N,M;
	static int R=2;
	static boolean[] isSelected;
	static int[] arr;
	static int sum;
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			isSelected = new boolean[N];
			list = new ArrayList<>();
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st2.nextToken());
			}
			//입력 끝
			
			comb(0,0);
			if(list.isEmpty()) {
				System.out.println("#"+tc+" "+"-1");
				continue;
			}
			int max = 0;
			for(int i=0,size=list.size();i<size;i++) {
				max = Math.max(max, list.get(i));
			}
			System.out.println("#"+tc+" "+max);
		}
		

	}
	
	static void comb(int target,int cnt) {
		if(cnt== R) {
			sum=0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					sum +=arr[i];
				}
			}
			if(sum<=M) {
				list.add(sum);
			}
			return;
			
		}
		if(target==N) {
			return;
		}
		
		isSelected[target]=true;
		comb(target+1,cnt+1);
		isSelected[target]=false;
		comb(target+1,cnt);
	}
}
