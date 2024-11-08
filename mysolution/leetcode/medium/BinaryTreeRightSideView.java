package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {

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

  public List<Integer> rightSideView(TreeNode root) {

    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.addLast(root);

    while (!deque.isEmpty()) {
      int dequeSize = deque.size();
      for (int i = 0; i < dequeSize; i++) {
        TreeNode currentNode = deque.pollFirst();
        if (i == dequeSize - 1) {
          result.add(currentNode.val);
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
