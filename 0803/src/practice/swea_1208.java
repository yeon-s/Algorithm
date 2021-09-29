package practice;

import java.util.Scanner;

public class swea_1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[10];
		for(int tc=0;tc<10;tc++) {
			
			int diff =0;
			int dump = sc.nextInt();
			int[] arr= new int[100];
			for(int i=0;i<100;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<=dump;i++) {
				int max=0;
				int min=101;
				for(int j=0;j<arr.length;j++) {
					max = Math.max(max, arr[j]);
					min = Math.min(min, arr[j]);
				}
				
				for(int j=0;j<arr.length;j++) {
					if(arr[j]==max) {
						arr[j]=arr[j]-1;
						break;
					}
				}
				for(int j=0;j<arr.length;j++) {
					if(arr[j]==min) {
						arr[j]=arr[j]+1;
						break;
					}
				}
				
				for(int j=0;j<arr.length;j++) {
					max = Math.max(max, arr[j]);
					min = Math.min(min, arr[j]);
				}
				diff = max-min;
				if(diff<=1) {
					break;
				}
			}
			result[tc]=diff;
			
		}
		for(int i=0;i<result.length;i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}

}
