package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

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

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		postorderTraversal(root, answer);
		return answer;
	}

	private void postorderTraversal(TreeNode root, List<Integer> answer) {

		if (root == null) {
			return;
		}

		if (root.left != null) {
			postorderTraversal(root.left, answer);
		}

		if (root.right != null) {
			postorderTraversal(root.right, answer);
		}

		answer.add(root.val);

		return;
	}

}
