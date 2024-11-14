package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import leetcode.easy.RangeSumOfBst.TreeNode;

public class MinimumAbsoluteDifferenceInBst {

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

  public int getMinimumDifference(TreeNode root) {

    List<Integer> list = new ArrayList<>();

    bst(root, list);

    int result = Integer.MAX_VALUE;

    for (int i = 0; i < list.size() - 1; i++) {
      result = Math.min(result, Math.abs(list.get(i) - list.get(i + 1)));
    }

    return result;
  }

  private void bst(TreeNode node, List<Integer> list) {

    if (node.left == null && node.right == null) {
      list.add(node.val);
      return;
    }

    if (node.left != null) {
      bst(node.left, list);
    }

    list.add(node.val);

    if (node.right != null) {
      bst(node.right, list);
    }
  }

}
