package leetcode.easy;

public class MiddleOfTheLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode middleNode(ListNode head) {

		ListNode slowNode = head;
		ListNode fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			if (fastNode.next.next == null) {
				fastNode = fastNode.next;
				break;
			}
			fastNode = fastNode.next.next;
		}

		return slowNode;

	}
}
