package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDifferenceBetweenNodeAndAncestor {

    static int maxDifference;

    public class TreeNode {
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

    public int maxAncestorDiff(TreeNode root) {

        maxDifference = 0;
        Deque<Integer> ancestorDeque = new ArrayDeque<>();

        dfs(root, ancestorDeque);

        return maxDifference;

    }

    private void dfs(TreeNode node, Deque<Integer> ancestorDeque) {

        if (ancestorDeque.isEmpty()) {
            ancestorDeque.addLast(node.val);
        } else {
            for (Integer ancestor : ancestorDeque) {
                if (Math.abs(ancestor - node.val) > maxDifference) {
                    maxDifference = Math.abs(ancestor - node.val);
                }
            }
            ancestorDeque.addLast(node.val);
        }

        if (node.left != null) {
            dfs(node.left, ancestorDeque);
        }

        if (node.right != null) {
            dfs(node.right, ancestorDeque);
        }

        ancestorDeque.pollLast();

    }

}
