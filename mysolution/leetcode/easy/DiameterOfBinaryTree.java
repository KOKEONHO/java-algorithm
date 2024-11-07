package leetcode.easy;

import leetcode.easy.BinaryTreeInorderTraversal.TreeNode;

public class DiameterOfBinaryTree {

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

  static int result = 0;

  public int diameterOfBinaryTree(
      TreeNode root
  ) {

    result = 0;

    if (root == null) {
      return result;
    }

    deriveAnswer(root);

    return result;

  }

  private static int deriveAnswer(
      TreeNode node
  ) {
    if (node == null) {
      return 0;
    }

    int left = deriveAnswer(node.left);
    int right = deriveAnswer(node.right);

    if (result < left + right) {
      result = left + right;
    }

    return Math.max(left, right) + 1;

  }

}
