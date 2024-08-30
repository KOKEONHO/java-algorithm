package leetcode.medium;

public class CountGoodNodesInBinaryTree {

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

	public int goodNodes(TreeNode root) {
		return goodNodes(root, Integer.MIN_VALUE);
	}

	private static int goodNodes(TreeNode root, int maxValue) {

		int count = 0;

		if (root.val >= maxValue) {
			maxValue = root.val;
			count++;
		}

		if (root.left != null) {
			count += goodNodes(root.left, maxValue);
		}

		if (root.right != null) {
			count += goodNodes(root.right, maxValue);
		}

		return count;

	}

}
