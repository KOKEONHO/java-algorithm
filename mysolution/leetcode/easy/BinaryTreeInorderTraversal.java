package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

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

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		inorderTraversal(root, answer);
		return answer;
	}

	private void inorderTraversal(TreeNode root, List<Integer> answer) {

		if (root == null) {
			return;
		}

		if (root.left != null) {
			inorderTraversal(root.left, answer);
		}

		answer.add(root.val);

		if (root.right != null) {
			inorderTraversal(root.right, answer);
		}

		return;

	}

}
