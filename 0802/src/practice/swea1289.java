package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1289 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String TC = br.readLine();
			int tc= Integer.parseInt(TC);
			int[] result = new int[tc];
			for(int k=0;k<tc;k++) {
				
				String str = br.readLine();
				char[] origin = str.toCharArray();
				char[] curr = new char[str.length()];
				for(int i=0;i<curr.length;i++) {
					curr[i]='0';
				}
				int count =0;
				
				for(int i=0;i<origin.length;i++) {
					if(origin[i]=='1') {
						if(origin[i]!=curr[i]) {
							count++;
							for(int j=i;j<origin.length;j++) {
								curr[j]='1';
							}
						}
					}else if(origin[i]=='0') {
						if(origin[i]!=curr[i]) {
							count++;
							for(int j=i;j<origin.length;j++) {
								curr[j]='0';
							}
						}
					}
				}
				result[k]=count;
			}
			int num=1;
			for(int i=0;i<tc;i++) {
				System.out.println("#"+num+" "+result[i]);
				num++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
