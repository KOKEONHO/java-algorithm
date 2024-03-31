package leetcode.easy;

class ReverseLinkedList {
	// ListNode 클래스를 내부 클래스로 선언
	private static class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode dummy = new ListNode();
		ListNode current = head;

		while (current != null) {
			ListNode next = current.next;
			current.next = dummy.next;
			dummy.next = current;
			current = next;
		}

		return dummy.next;
	}
}