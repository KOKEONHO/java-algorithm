package leetcode.easy;

public class LinkedListCycle {

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {

		ListNode slowNode = head;
		ListNode fastNode = head;

		while (fastNode != null && fastNode.next != null) {

			slowNode = slowNode.next;
			fastNode = fastNode.next.next;

			if (slowNode == fastNode) {
				return true;
			}
		}

		return false;

	}
}
