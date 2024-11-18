package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReachableNodesWithRestrictions {

  int[] restricted;
  boolean[] visited;
  Set<Integer> restrictedSet = new HashSet<>();
  Map<Integer, List<Integer>> graph = new HashMap<>();

  public int reachableNodes(int n, int[][] edges, int[] restricted) {

    visited = new boolean[n];
    for (int restrictedNumber : restricted) {
      restrictedSet.add(restrictedNumber);
    }

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

    return dfs(0);

  }

  private int dfs(int node) {

    int nodeCount = 1;

    visited[node] = true;
    for (int neighbor : graph.get(node)) {
      if (restrictedSet.contains(neighbor)) {
        continue;
      }
      if (!visited[neighbor]) {
        nodeCount += dfs(neighbor);
      }
    }

    return nodeCount;

  }

}
