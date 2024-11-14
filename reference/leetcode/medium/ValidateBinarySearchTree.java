package leetcode.medium;

public class ValidateBinarySearchTree {

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

  public boolean isValidBST(TreeNode root) {
    return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean dfs(TreeNode node, long small, long large) {
    if (node == null) {
      return true;
    }

    if (small >= node.val || node.val >= large) {
      return false;
    }

    return dfs(node.left, small, node.val) && dfs(node.right, node.val, large);
  }
}
