package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1218_괄호짝 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int size = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] ch = new char[size];
			ch =str.toCharArray();
			//입력 끝
			
			int[] save = new int[8];
			char[] text = {'[','{','(','<',']','}',')','>'};
			for(int i=0;i<save.length;i++) {
				save[i]=count(ch,text[i]);
			}
			
			if(save[0]==save[4]&&save[1]==save[5]&&save[2]==save[6]&&save[3]==save[7]) {
				System.out.println("#"+tc+" "+"1");
			}else {
				System.out.println("#"+tc+" "+"0");
			}
		}
	}
	
	public static int count(char[] ch,char c) {
		int cnt =0;
		for(int i=0;i<ch.length;i++) {
			if(ch[i]==c) {
				cnt++;
			}
		}
		return cnt;
	}
}
