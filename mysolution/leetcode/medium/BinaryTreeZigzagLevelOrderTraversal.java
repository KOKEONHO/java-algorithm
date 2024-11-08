package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import leetcode.medium.BinaryTreeRightSideView.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

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

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    int count = 0;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.addLast(root);

    while (!deque.isEmpty()) {
      int dequeSize = deque.size();
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < dequeSize; i++) {
        if (count % 2 == 0) {
          TreeNode currentNode = deque.pollFirst();
          list.add(currentNode.val);
          if (currentNode.left != null) {
            deque.addLast(currentNode.left);
          }
          if (currentNode.right != null) {
            deque.addLast(currentNode.right);
          }
        } else {
          TreeNode currentNode = deque.pollLast();
          list.add(currentNode.val);
          if (currentNode.right != null) {
            deque.addFirst(currentNode.right);
          }
          if (currentNode.left != null) {
            deque.addFirst(currentNode.left);
          }
        }
      }

      result.add(list);
      count++;
    }

    return result;

  }

}
