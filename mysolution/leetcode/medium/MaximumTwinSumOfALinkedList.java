package leetcode.medium;

public class MaximumTwinSumOfALinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public int pairSum(ListNode head) {

		ListNode slowNode = head;
		ListNode fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}

		ListNode nextNode = null;
		ListNode previousNode = null;

		while (slowNode != null) {
			nextNode = slowNode.next;
			slowNode.next = previousNode;
			previousNode = slowNode;
			slowNode = nextNode;
		}

		int result = 0;

		while (previousNode != null) {
			result = Math.max(result, head.val + previousNode.val);
			head = head.next;
			previousNode = previousNode.next;
		}

		return result;

	}
}
