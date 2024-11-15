package leetcode.easy;

public class ClosestBinarySearchTreeValueReference {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

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
