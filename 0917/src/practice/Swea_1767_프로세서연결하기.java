package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_1767_프로세서연결하기 {

	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static int N;
	static List<Point> pointList;
	static int[] direction;
	static int maxCore;
	static int minLine;
	static List<One> result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			pointList = new ArrayList<>();
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
					if(i!=0 && j!=0 && i!=N-1 && j!=N-1 && map[i][j]==1) {
						pointList.add(new Point(i, j));
					}
				}
			}
			//입력 끝
			direction = new int[pointList.size()];
			maxCore= -1;
			minLine= 400;
			result = new ArrayList<>();
			comb(0);
			
			for(int i=0;i<result.size();i++) {
				if(result.get(i).coreCount==maxCore) {
					minLine = Math.min(minLine, result.get(i).lineLength);
				}
			}
			System.out.println("#"+tc+" "+minLine);
			
		}

	}
	
	static void comb(int cnt) {
		if(cnt==pointList.size()) {
			
			check(direction);
			return;
		}
		
		for(int i=0;i<4;i++) {
			direction[cnt] = i;
			comb(cnt+1);
		}
	}
	
	static void check(int[] direction) {
		int[][] copyMap = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for(int i=0;i<pointList.size();i++) {
			int nowi = pointList.get(i).i;
			int nowj = pointList.get(i).j;
			
			if(direction[i]==0) {
				boolean flag = true;
				for(int j=nowi-1;j>=0;j--) {
					if(copyMap[j][nowj]==1 || copyMap[j][nowj]==2) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=nowi-1;j>=0;j--) {
						copyMap[j][nowj]=2;
					}
				}
			}else if(direction[i]==1) {
				boolean flag = true;
				for(int j=nowi+1;j<=N-1;j++) {
					if(copyMap[j][nowj]==1 || copyMap[j][nowj]==2) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=nowi+1;j<=N-1;j++) {
						copyMap[j][nowj]=2;
					}
				}
			}else if(direction[i]==2) {
				boolean flag = true;
				for(int j=nowj-1;j>=0;j--) {
					if(copyMap[nowi][j]==1 || copyMap[nowi][j]==2) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=nowj-1;j>=0;j--) {
						copyMap[nowi][j]=2;
					}
				}
			}else if(direction[i]==3) {
				boolean flag = true;
				for(int j=nowj+1;j<=N-1;j++) {
					if(copyMap[nowi][j]==1 || copyMap[nowi][j]==2) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=nowj+1;j<=N-1;j++) {
						copyMap[nowi][j]=2;
					}
				}
			}
			
		}

		int coreCount=0;
		int lineLength=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copyMap[i][j]==2) {
					lineLength++;
				}
				if(i==0 || j==0 || i==N-1 || j==N-1) {
					if(copyMap[i][j]== 1 ||copyMap[i][j]== 2) {
						coreCount++;
					}
				}
			}
		}
		maxCore = Math.max(maxCore, coreCount);
		
		result.add(new One(coreCount, lineLength));
	}
	
	static class One{
		int coreCount;
		int lineLength;
		public One(int coreCount, int lineLength) {
			super();
			this.coreCount = coreCount;
			this.lineLength = lineLength;
		}
		
	}
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}
