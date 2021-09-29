package pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_배틀필드 {
	static int di[] = {-1,1,0,0};// up down left right
	static int dj[] = {0,0,-1,1};
	static char[] arrow = {'^','v','<','>'};
	static char[] orderDir = {'U','D','L','R'};
	
	static int tanki, tankj, tankd; // 0:up 1:down 2:left 3:right
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
			} 
			
			int orderCnt = Integer.parseInt(br.readLine()); // 명령 갯수
			char[] order = br.readLine().toCharArray(); // 명령배열
			// end input
			
			for(int i=0; i<H; i++) {// 지도 탐색해서 초기 탱크좌표와 그 방향 찾아내자.
				for(int j=0; j<W; j++) {
					for(int d=0; d<4; d++) {
						if(map[i][j] == arrow[d]) {
							tanki = i;
							tankj = j;
							tankd = d;
							map[i][j] = '.'; // 탱크는 공중으로 띄워놓고 동작시키자. 탱크 위치 갱신하는거 귀찮아
						}
					}
				}
			} 
			
			for(char ch : order) { // 모든 명령 수행
				if(ch=='S') { // 포탄(벽돌은 깸. 그 나머지는 아무일 없음.)
					int si = tanki, sj=tankj; // 포탄 출발위치
					
					while(true) { // 포탄 무한 직진
						if(si<0 || si>=H || sj<0 || sj>=W || map[si][sj]=='#') break;
						
						if(map[si][sj]=='*') { // 벽돌이다! 깨부셔!!
							map[si][sj] = '.';
							break;
						}
						
						si = si + di[tankd]; // 기존 포탄 좌표에서 탱크가 쳐다보는 방향으로 한칸 이동한 좌표로 갱신.
						sj = sj + dj[tankd];
					}
				}else { // 이동
					for(int d=0; d<4; d++) { // 어느 방향으로 가래 ? 조건문 4개 귀찮아 반복문으로 찾자.
						if(ch == orderDir[d]) { // U, D, L, R = 0:up 1:down 2:left 3:right
							tankd = d;
							break;
						}
					}
					
					int ni = tanki + di[tankd]; // 이동 예정 좌표 계산해보기
					int nj = tankj + dj[tankd];
					
					if(ni>=0 && ni<H && nj>=0 && nj<W && map[ni][nj]=='.') { // 이동 가능조건은 평지만!
						tanki = ni;
						tankj = nj;
					}
				}
//				print(map);
			} // end order
			
			// 모든 명령 끝났으면 탱크를 착륙시키자.
			map[tanki][tankj] = arrow[tankd];
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<H; i++) {// 지도 탐색해서 초기 탱크좌표와 그 방향 찾아내자.
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			} 
		}
	}

	static void print(char[][] map) {
		for(int i=0; i<map.length; i++) {// 지도 탐색해서 초기 탱크좌표와 그 방향 찾아내자.
			for(int j=0; j<map[i].length; j++) {
				if(i==tanki && j==tankj)
					System.out.print(arrow[tankd]);
				else
					System.out.print(map[i][j]);
			}
			System.out.println();
		} 
		System.out.println("------------------------------------");
	}
}





