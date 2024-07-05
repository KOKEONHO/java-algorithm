package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {

		int numsLength = nums.length;
		Deque<Integer> deque = new ArrayDeque<>();
		int[] result = new int[(numsLength - k) + 1];

		for (int i = 0; i < numsLength; i++) {
			int number = nums[i];

			while (!deque.isEmpty() && nums[deque.getLast()] < number) {
				deque.removeLast();
			}
			deque.addLast(i);

			if (i >= k - 1) {
				while (i - deque.getFirst() >= k) {
					deque.removeFirst();
				}
				result[i - (k - 1)] = nums[deque.getFirst()];
			}

		}

		return result;

	}
}
