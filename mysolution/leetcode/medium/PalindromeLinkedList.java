package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalindromeLinkedList {
	/**
	 * Definition for singly-linked list.
	 * private class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
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

	public boolean isPalindrome(ListNode head) {
		List<Integer> valueList = new ArrayList<>();

		while (head != null) {
			valueList.add(head.val);
			head = head.next;
		}

		for (int i = 0; i < valueList.size() / 2; i++) {
			if (!Objects.equals(valueList.get(i), valueList.get(valueList.size() - (i + 1)))) {
				return false;
			}
		}

		return true;
	}
}