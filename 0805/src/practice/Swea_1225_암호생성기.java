package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int trash = sc.nextInt();
			int[] arr = new int[8];
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
				queue.offer(arr[i]);
			}
			
			while(true) {
				for(int i=1;i<=5;i++) {
					int num=0;
					num = queue.poll()-i;
					if(num<=0) {
						num=0;
						queue.offer(num);
						break;
					}
					queue.offer(num);
				}
				if(queue.contains(0)) {
					break;
				}
			}
			int[] pwd = new int[8];
			for(int i=0;i<8;i++) {
				pwd[i]=queue.poll();
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<8;i++) {
				System.out.print(pwd[i]+" ");
			}
			System.out.println();
		}

	}

}
