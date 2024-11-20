package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllNodesDistanceKInBinaryTreeReference {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

  }

  Map<TreeNode, TreeNode> parents = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

    dfs(root, null);
    Deque<TreeNode> deque = new ArrayDeque<>();
    Set<TreeNode> visited = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    deque.addLast(target);

    while (!deque.isEmpty() && k > 0) {
      int currentLength = deque.size();
      for (int i = 0; i < currentLength; i++) {
        TreeNode currentNode = deque.pollFirst();
        visited.add(currentNode);
        if (currentNode.left != null && !visited.contains(currentNode.left)) {
          deque.addLast(currentNode.left);
        }
        if (currentNode.right != null && !visited.contains(currentNode.right)) {
          deque.addLast(currentNode.right);
        }
        if (parents.get(currentNode) != null && !visited.contains(parents.get(currentNode))) {
          deque.addLast(parents.get(currentNode));
        }
      }
      k--;
    }

    while (!deque.isEmpty()) {
      result.add(deque.pollFirst().val);
    }
    return result;

  }

  private void dfs(TreeNode node, TreeNode parent) {
    if (node == null) {
      return;
    }

    parents.put(node, parent);

    dfs(node.left, node);
    dfs(node.right, node);
  }

}
