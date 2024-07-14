package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTheMostCompetitiveSubsequence {
	public int[] mostCompetitive(int[] nums, int k) {

		int numsLength = nums.length;
		Deque<Integer> deque = new ArrayDeque<>();

		int removableCount = numsLength - k;

		for (int i = 0; i < numsLength; i++) {
			int number = nums[i];
			while (!deque.isEmpty() && deque.peekLast() > number && removableCount > 0) {
				deque.pollLast();
				removableCount--;
			}
			deque.addLast(number);
		}

		int[] result = new int[k];

		for (int i = 0; i < k; i++) {
			result[i] = deque.pollFirst();
		}

		return result;

	}
}
