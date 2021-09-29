package pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1873_배틀필드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			String hw = br.readLine();
			StringTokenizer st = new StringTokenizer(hw);
			
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			String[][] map = new String[h][w];
			
			for(int i=0;i<h;i++) {
				String str = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j] = str.substring(j,j+1);
				}
			}
			
			int num = Integer.parseInt(br.readLine());
			char[] ch = new char[num];
			ch=br.readLine().toCharArray();
			
			int nowi=0;
			int nowj=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j].equals("^")||map[i][j].equals("<")||map[i][j].equals(">")||map[i][j].equals("v")) {
						nowi=i;
						nowj=j;
					}
				}
			}
			int[] di= {-1,0,1,0}; 	//상 우 하 좌
			int[] dj = {0,1,0,-1};
			for(int i=0;i<ch.length;i++) {
				if(ch[i]=='S') {
					if(map[nowi][nowj].equals("^")&&nowi!=0) {
						for(int k=nowi;k>=0;k--) {
							if(map[k][nowj].equals("#")) {
								break;
							}
							if(map[k][nowj].equals("*")) {
								map[k][nowj]=".";
								break;
							}
						}
					}else if(map[nowi][nowj].equals(">")&&nowj!=w-1) {
						for(int k=nowj;k<w;k++) {
							if(map[nowi][k].equals("#")) {
								break;
							}
							if(map[nowi][k].equals("*")) {
								map[nowi][k]=".";
								break;
							}
						}
					}else if(map[nowi][nowj].equals("v")&&nowi!=h-1) {
						for(int k=nowi;k<h;k++) {
							if(map[k][nowj].equals("#")) {
								break;
							}
							if(map[k][nowj].equals("*")) {
								map[k][nowj]=".";
								break;
							}
						}
					}else if(map[nowi][nowj].equals("<")&&nowj!=0) {
						for(int k=nowj;k>=0;k--) {
							if(map[nowi][k].equals("#")) {
								break;
							}
							if(map[nowi][k].equals("*")) {
								map[nowi][k]=".";
								break;
							}
						}
					}
				}else if(ch[i]=='R') {
					map[nowi][nowj]=">";
					if(nowj+dj[1]<w && map[nowi+di[1]][nowj+dj[1]].equals(".")) {
						map[nowi][nowj]=".";
						nowi=nowi+di[1];
						nowj=nowj+dj[1];
						map[nowi][nowj]=">";
					}
				}else if(ch[i]=='L') {
					map[nowi][nowj]="<";
					if(nowj+dj[3]>=0 && map[nowi+di[3]][nowj+dj[3]].equals(".")) {
						map[nowi][nowj]=".";
						nowi=nowi+di[3];
						nowj=nowj+dj[3];
						map[nowi][nowj]="<";
					}
				}else if(ch[i]=='D') {
					map[nowi][nowj]="v";
					if(nowi+di[2]<h && map[nowi+di[2]][nowj+dj[2]].equals(".")) {
						map[nowi][nowj]=".";
						nowi=nowi+di[2];
						nowj=nowj+dj[2];
						map[nowi][nowj]="v";
					}
				}else if(ch[i]=='U') {
					map[nowi][nowj]="^";
					if(nowi+di[0]>=0 && map[nowi+di[0]][nowj+dj[0]].equals(".")) {
						map[nowi][nowj]=".";
						nowi=nowi+di[0];
						nowj=nowj+dj[0];
						map[nowi][nowj]="^";
					}
				}
//				for(int q=0;q<h;q++) {
//					for(int j=0;j<w;j++) {
//						System.out.print(map[q][j]);
//					}
//					System.out.println();
//				}
//				System.out.println("==========================");
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
