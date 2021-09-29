package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_9229_한빈이와스팟마트2_반복문 {

	static int N,M;
	static int R=2;
	static int[] arr;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st2.nextToken());
			}
			//입력 끝
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(arr[i]+arr[j]<=M) {
						list.add(arr[i]+arr[j]);
					}
				}
			}
			if(list.isEmpty()) {
				System.out.println("#"+tc+" "+"-1");
				continue;
			}
			int max=0;
			for(int i=0;i<list.size();i++) {
				max=Math.max(max, list.get(i));
			}
			System.out.println("#"+tc+" "+max);
		}
		

	}
	
}
