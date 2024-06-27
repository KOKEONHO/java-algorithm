package leetcode.medium;

public class SwapNodesInPairs {

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {

		ListNode result = null;

		ListNode firstNode = head;
		ListNode secondNode = head;

		ListNode nextNode = null;
		ListNode previousNode = null;

		if (head == null) {
			return head;
		}

		if (firstNode.next != null) {
			result = firstNode.next;
		}

		while (firstNode != null && firstNode.next != null) {
			secondNode = firstNode.next;
			if (previousNode != null) {
				previousNode.next = secondNode;
			}
			nextNode = secondNode.next;
			secondNode.next = firstNode;
			previousNode = firstNode;
			firstNode.next = nextNode;
			firstNode = nextNode;
		}

		if (result == null) {
			return head;
		}
		return result;

	}
}
