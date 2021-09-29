package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3234_준환이양팔저울_경운이 {
   
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringTokenizer st;
   static int T, N, weights[], res, sum;
   static boolean isSelected[];
   static StringBuilder sb = new StringBuilder();
   
   public static void main(String[] args) throws Exception {
      T = stoi(br.readLine());
      for (int tc = 1; tc <= T; tc++) {
         input();
         perm(0, 0, 0, sum);
         saveResult(tc);
      }
      sb.setLength(sb.length() - 1);
      System.out.print(sb);
   }
   
   private static void saveResult(int tc) {
      sb.append("#").append(tc).append(" ").append(res).append("\n");
   }
   
   private static void perm(int cnt, int left, int right, int remain) {
      if(cnt == N) {
         ++res;
         return;
      }
      
      if(left >= right + remain) {
         res += powOfTwo(N - cnt) * factorial(N - cnt);
         return;
      }
      
      for (int i = 0; i < N; i++) {
         if(isSelected[i]) {
            continue;
         }
         isSelected[i] = true;
         perm(cnt + 1, left + weights[i], right, remain - weights[i]);
         int next = right + weights[i];
         if(next <= left) {
            perm(cnt + 1, left, next, remain - weights[i]);
         }
         isSelected[i] = false;
      }
   }

   private static int factorial(int i) {
      if(i == 0) {
         return 1;
      }
      int res = 1;
      for (int j = 1; j <= i; j++) {
         res *= j;
      }
      return res;
   }

   private static int powOfTwo(int i) {
      int res = 1;
      for (int j = 0; j < i; j++) {
         res *= 2;
      }
      return res;
   }

   private static void input() throws Exception {
      sum = 0;
      N = stoi(br.readLine());
      weights = new int[N];
      isSelected = new boolean[N];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         weights[i] = stoi(st.nextToken());
         sum += weights[i];
      }
      res = 0;
   }

   private static int stoi(String s) {
      return Integer.parseInt(s);
   }
}