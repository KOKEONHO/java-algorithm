package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIfPathExistsInGraph {

  boolean[] visited;
  Map<Integer, List<Integer>> graph = new HashMap<>();

  public boolean validPath(int n, int[][] edges, int source, int destination) {

    if (edges.length == 0) {
      return true;
    }

    visited = new boolean[n];

    for (int[] edge : edges) {
      int node = edge[0], neighbor = edge[1];
      if (!graph.containsKey(node)) {
        graph.put(node, new ArrayList<>());
      }
      if (!graph.containsKey(neighbor)) {
        graph.put(neighbor, new ArrayList<>());
      }
      graph.get(node).add(neighbor);
      graph.get(neighbor).add(node);
    }

    dfs(source);

    return visited[destination];

  }

  private void dfs(int node) {

    visited[node] = true;
    List<Integer> neighbors = graph.get(node);
    for (int neighbor : neighbors) {
      if (!visited[neighbor]) {
        dfs(neighbor);
      }
    }

  }

}
