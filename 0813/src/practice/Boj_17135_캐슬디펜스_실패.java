package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Boj_17135_캐슬디펜스_실패 {

	static int N,M,D;
	static int[] archer;
	static boolean[] isSelected;
	static List<Enemy> list;
	static int count;		//적의 수
	static int result=0;
	static int hunt;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		map = new int[N+1][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//입력 끝
		
		archer = new int[M];
		for(int i=0;i<M;i++) {
			archer[i] = i;
		}
		
		//적 위치 저장(배열)
//		count=0;
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(map[i][j]==1) {
//					count++;
//				}
//			}
//		}
//		enemies = new Enemy[count];
//		int index=0;
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(map[i][j]==1) {
//					enemies[index++] = new Enemy(i, j);
//				}
//			}
//		}
		
		
		//적 위치 저장(리스트)
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					list.add(new Enemy(i, j));
				}
			}
		}
		
		
		
		
		isSelected = new boolean[M];
		comb(0,0);
		System.out.println(hunt);
	}
	
	
	static Enemy findMin(int index) {
			if(isSelected[index]) {
				int[] distance= new int[list.size()];
				int min=Integer.MAX_VALUE;
				for(int j=0;j<list.size();j++) {
					int y = Math.abs(N-list.get(j).y);
					int x = Math.abs(archer[index]-list.get(j).x);
					distance[j] = x+y;
					min = Math.min(min, x+y);
				}	
				int flag=0;
				for(int i=0;i<distance.length;i++) {
					if(distance[i]==min) {
						flag++;
					}
				}
				if(flag>1) {
					int[] arr = new int[M];
					int index1=0;
					for(int i=0;i<distance.length;i++) {
						if(distance[i]==min) {
							arr[index1++]=i;
						}
					}
					Enemy e = null;
					for(int i=0;i<index1;i++) {
						e = list.get(i);
						for(int j=i;j<index1;j++) {
							if(e.x > list.get(j).x) {
								e=list.get(j);
							}							
						}
					}
					return e;
				}else {
					for(int i=0;i<distance.length;i++) {
						if(distance[i]==min) {
							return list.get(i);
						}
					}
				}
			}
			return null;
	}
	
	
	
	static void comb(int target, int cnt) {
		if(cnt==3) {
			hunt=0;
			for(int i =0;i<M;i++) {
				Enemy e = findMin(i);
				if(e==null) {
					continue;
				}
				int distanceMin = Math.abs(archer[i]-e.x)+Math.abs(N-e.y);
				if(distanceMin<=D) {
					map[e.y][e.x] = 0;
					list.remove(list.indexOf(e));
					hunt++;
				}
				
			}
			return;
		}
		if(target==M) {
			return;
		}
		
		isSelected[target]=true;
		comb(target+1,cnt+1);
		isSelected[target]=false;
		comb(target+1,cnt);
	}
	
	static class Enemy{
		int y;
		int x;
		public Enemy(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	

}
