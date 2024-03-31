package leetcode.medium;

public class MergeInBetweenLinkedLists {
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

	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		int iterationCount = 0;
		ListNode list1Current = list1;
		ListNode list2Current = list2;

		while (list1Current != null && iterationCount < a - 1) {
			list1Current = list1Current.next;
			iterationCount++;
		}

		ListNode replaceStart = list1Current;

		while (list1Current != null && iterationCount <= b) {
			list1Current = list1Current.next;
			iterationCount++;
		}

		ListNode replaceEnd = list1Current;

		while (list2Current.next != null) {
			list2Current = list2Current.next;
		}

		list2Current.next = replaceEnd;
		replaceStart.next = list2;

		return list1;
	}
}