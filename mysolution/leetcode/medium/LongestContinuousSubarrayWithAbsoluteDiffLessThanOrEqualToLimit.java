package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
	public int longestSubarray(int[] nums, int limit) {

		int numsLength = nums.length;
		Deque<Integer> increasing = new ArrayDeque<>();
		Deque<Integer> decreasing = new ArrayDeque<>();

		int left = 0;
		int result = 0;

		for (int right = 0; right < numsLength; right++) {
			int number = nums[right];

			while (!increasing.isEmpty() && increasing.getLast() > number) {
				increasing.removeLast();
			}

			while (!decreasing.isEmpty() && decreasing.getLast() < number) {
				decreasing.removeLast();
			}

			increasing.addLast(number);
			decreasing.addLast(number);

			while (decreasing.getFirst() - increasing.getFirst() > limit) {

				if (increasing.getFirst() == nums[left]) {
					increasing.removeFirst();
				}

				if (decreasing.getFirst() == nums[left]) {
					decreasing.removeFirst();
				}

				left++;

			}

			result = Math.max(result, right - left + 1);

		}

		return result;

	}
}
