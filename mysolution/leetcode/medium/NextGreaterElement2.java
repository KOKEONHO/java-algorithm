package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement2 {
	public int[] nextGreaterElements(int[] nums) {

		int numsLength = nums.length;
		int[] result = new int[numsLength];
		Deque<Integer> deque = new ArrayDeque<>();

		Arrays.fill(result, -1);

		for (int i = 0; i < numsLength * 2; i++) {
			int currentNumber = nums[i % numsLength];
			while (!deque.isEmpty()) {
				if (nums[deque.peek()] < currentNumber) {
					result[deque.pop()] = currentNumber;
				} else {
					break;
				}
			}
			deque.push(i % numsLength);
		}

		return result;

	}
}
