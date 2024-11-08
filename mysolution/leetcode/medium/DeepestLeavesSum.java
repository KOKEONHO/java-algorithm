package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeepestLeavesSum {

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

  public int deepestLeavesSum(TreeNode root) {

    int result = 0;

    if (root == null) {
      return result;
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.addLast(root);

    while (!deque.isEmpty()) {
      result = 0;
      int dequeSize = deque.size();
      for (int i = 0; i < dequeSize; i++) {
        TreeNode currentNode = deque.pollFirst();
        if (currentNode.left == null && currentNode.right == null) {
          result += currentNode.val;
          continue;
        }
        if (currentNode.left != null) {
          deque.addLast(currentNode.left);
        }
        if (currentNode.right != null) {
          deque.addLast(currentNode.right);
        }
      }
    }

    return result;

  }
}
