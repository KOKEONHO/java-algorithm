package leetcode.medium;

public class NumberOfProvinces {

  int provinceCount = 0;

  public int findCircleNum(int[][] isConnected) {

    boolean[] visited = new boolean[isConnected.length];

    for (int i = 0; i < isConnected.length; i++) {
      if (!visited[i]) {
        dfs(isConnected, visited, i);
        provinceCount++;
      }
    }

    return provinceCount;
  }

  private void dfs(
      int[][] isConnected,
      boolean[] visited,
      int node
  ) {
    visited[node] = true;
    for (int i = 0; i < isConnected[node].length; i++) {
      if (isConnected[node][i] == 1 && !visited[i]) {
        dfs(isConnected, visited, i);
      }
    }
  }

}
