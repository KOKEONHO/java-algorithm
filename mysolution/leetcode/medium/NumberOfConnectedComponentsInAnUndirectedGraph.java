package leetcode.medium;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

  boolean[] visited;
  int[][] graph;

  public int countComponents(int n, int[][] edges) {

    int result = 0;
    graph = new int[n][n];
    visited = new boolean[n];

    for (int[] edge : edges) {
      int node = edge[0], neighbor = edge[1];
      graph[node][node] = 1;
      graph[node][neighbor] = 1;
      graph[neighbor][node] = 1;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i);
        result++;
      }
    }

    return result;

  }

  private void dfs(int node) {

    visited[node] = true;
    for (int i = 0; i < graph[node].length; i++) {
      if (!visited[i] && graph[node][i] == 1) {
        dfs(i);
      }
    }

  }

}
