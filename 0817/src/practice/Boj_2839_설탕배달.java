package practice;

import java.util.Scanner;

public class Boj_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int five=0;
		int three=0;
		int rest=0;
		
		if(N ==1 || N==2 || N==4||N==7) {
			System.out.println("-1");
		}else if(N%5==0) {
			five = N/5;
			System.out.println(five);
		}else if(N%15 !=3||N%15 !=6||N%15 !=9||N%15 !=12){
			for(int i=1;i<10;i++) {
				rest = N-(3*i);
				if(rest%5==0) {
					three = i;
					five = rest/5;
					System.out.println(five+three);
					break;
				}
			}
		}else {
			System.out.println(N/3);
		}
		
		
		
	}

}
