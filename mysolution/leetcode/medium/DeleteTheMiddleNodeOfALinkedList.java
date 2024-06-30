package leetcode.medium;

public class DeleteTheMiddleNodeOfALinkedList {

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

	public ListNode deleteMiddle(ListNode head) {

		if (head.next == null) {
			return null;
		}

		ListNode slowNode = head;
		ListNode fastNode = head;

		ListNode nextNode = null;
		ListNode previousNode = null;

		while (fastNode != null && fastNode.next != null) {
			previousNode = slowNode;
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		nextNode = slowNode.next;

		previousNode.next = nextNode;

		return head;
	}
}
