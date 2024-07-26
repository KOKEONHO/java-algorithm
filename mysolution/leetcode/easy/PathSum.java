package leetcode.easy;

public class PathSum {
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

	public boolean hasPathSum(TreeNode root, int targetSum) {

		if (root == null) {
			return false;
		}

		boolean left = false, right = false;
		targetSum -= root.val;

		if (targetSum == 0) {
			if (root.left == null && root.right == null) {
				return true;
			}
		}

		if (root.left != null) {
			left = hasPathSum(root.left, targetSum);
		}

		if (root.right != null) {
			right = hasPathSum(root.right, targetSum);
		}

		if (left || right) {
			return true;
		}
		return false;

	}
}
