package leetcode.easy;

public class MaximumDepthOfBinaryTree {

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

	int depth = 0;
	int maximumDepth = Integer.MIN_VALUE;

	public int maxDepth(TreeNode root) {

		if (root == null) {
			maximumDepth = Math.max(maximumDepth, depth);
			return maximumDepth;
		}

		depth++;
		maxDepth(root.left);
		maxDepth(root.right);
		depth--;

		return maximumDepth;
	}

}
