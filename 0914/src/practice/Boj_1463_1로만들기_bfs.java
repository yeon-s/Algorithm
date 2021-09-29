package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1463_1로만들기_bfs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(bfs(N));
	}

	static int bfs(int N) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(N);
		visited[N]= true;
		int depth =0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int num = queue.poll();
				
				if(num==1) {
					return depth;
				}
				if(num%3==0 && !visited[num/3] ) {
					queue.offer(num/3);
					visited[num/3] = true;
				}
				if(num%2==0 && !visited[num/2] ) {
					queue.offer(num/2);
					visited[num/2] = true;
				}
				if(!visited[num-1] ) {
					queue.offer(num-1);
					visited[num-1] = true;
				}
			}
			depth++;
		}
		return -1;
	}
}
