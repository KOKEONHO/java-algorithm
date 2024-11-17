package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

    boolean[] incomingNode = new boolean[n];
    List<Integer> result = new ArrayList<>();

    for (List<Integer> edge : edges) {
      incomingNode[edge.get(1)] = true;
    }

    for (int i = 0; i < n; i++) {
      if (!incomingNode[i]) {
        result.add(i);
      }
    }

    return result;

  }

}
