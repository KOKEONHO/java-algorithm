package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_1 {

  static int N;
  static int M;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int depth = 0;
    int[] result = new int[M];
    boolean[] visited = new boolean[N];

    permutation(depth, visited, result);

    System.out.println(sb);

  }

  private static void permutation(int depth, boolean[] visited, int[] result) {

    if (depth == M) {
      for (int num : result) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        result[depth] = i + 1;
        permutation(depth + 1, visited, result);
        visited[i] = false;
      }
    }

  }
}

