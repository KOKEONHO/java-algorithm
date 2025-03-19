package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {

  static int N;
  static int count;
  static int[] queen;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    queen = new int[N];

    nQueen(0);

    System.out.println(count);

  }

  private static void nQueen(int depth) {

    if (depth == N) {
      count++;
      return;
    }

    for (int i = 0; i < N; i++) {
      queen[depth] = i;
      if (checkPossibility(depth)) {
        nQueen(depth + 1);
      }
    }

  }

  private static boolean checkPossibility(int depth) {

    for (int i = 0; i < depth; i++) {
      if (queen[depth] == queen[i]) {
        return false;
      }
    }

    for (int i = 0; i < depth; i++) {
      if (Math.abs(depth - i) == Math.abs(queen[depth] - queen[i])) {
        return false;
      }
    }

    return true;

  }

}
