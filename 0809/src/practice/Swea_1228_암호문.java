package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_1228_암호문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			int N = Integer.parseInt(br.readLine());
			//String[] origin = new String[N];
			List<String> list = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(st.nextToken()+" ");
			}
			int ord = Integer.parseInt(br.readLine());
			String[] order = new String[ord];
			StringTokenizer st2 = new StringTokenizer(br.readLine(),"I");
			for(int i=0;i<ord;i++) {
				order[i]=st2.nextToken();
			}
			
			//입력 끝
			
			for(int i=0;i<ord;i++) {
				StringTokenizer st3 = new StringTokenizer(order[i]);
				int index = Integer.parseInt(st3.nextToken());
				int count = Integer.parseInt(st3.nextToken());
				for(int j=0;j<count;j++) {
					list.add(index++, st3.nextToken()+" ");
				}
				
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<10;i++) {
				System.out.print(list.get(i));				
			}
			System.out.println();
		}

	}

}
