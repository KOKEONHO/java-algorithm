package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZeroReference {

  boolean[] visited;
  Set<String> original = new HashSet<>();
  Map<Integer, List<Integer>> graph = new HashMap<>();

  public int minReorder(int n, int[][] connections) {

    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int[] connection : connections) {
      int node = connection[0], neighbor = connection[1];
      graph.get(node).add(neighbor);
      graph.get(neighbor).add(node);
      original.add(convertToHash(node, neighbor));
    }

    return dfs(0);

  }

  private int dfs(int node) {

    int count = 0;
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
      if (!visited[neighbor]) {
        if (original.contains(convertToHash(node, neighbor))) {
          count++;
        }
        count += dfs(neighbor);
      }
    }

    return count;

  }

  private String convertToHash(int node, int neighbor) {
    return String.valueOf(node) + "," + String.valueOf(neighbor);
  }

}
