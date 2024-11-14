package leetcode.easy;

public class ClosestBinarySearchTreeValue {

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

  private int result = Integer.MAX_VALUE;

  public int closestValue(TreeNode root, double target) {

    dfs(root, target);

    return result;
  }

  private void dfs(TreeNode node, double target) {

    if (node == null) { // base case
      return;
    }

    if (Math.abs(result - target) >= Math.abs(node.val - target)) {
      if (Math.abs(result - target) == Math.abs(node.val - target)) {
        result = Math.min(result, node.val);
      } else {
        result = node.val;
      }
    }

    dfs(node.left, target);
    dfs(node.right, target);

    return;

  }

}
