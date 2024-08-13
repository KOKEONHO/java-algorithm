package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

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

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> arrayList = new ArrayList<>();
		preorderTraversal(root, arrayList);
		return arrayList;
	}

	private void preorderTraversal(TreeNode root, List<Integer> answer) {

		if (root == null) {
			return;
		}

		answer.add(root.val);
		preorderTraversal(root.left, answer);
		preorderTraversal(root.right, answer);

		return;
	}

}
