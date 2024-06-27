package leetcode.easy;

public class RemoveDuplicatesFromSortedList {

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {

		ListNode pinNode = head;
		ListNode searchNode = head;

		if (head == null) {
			return head;
		}

		while (searchNode.next != null) {
			searchNode = searchNode.next;
			while (searchNode != null && pinNode.val == searchNode.val) {
				searchNode = searchNode.next;
			}
			if (searchNode == null) {
				pinNode.next = null;
				break;
			}
			pinNode.next = searchNode;
			pinNode = pinNode.next;
		}

		return head;

	}
}
