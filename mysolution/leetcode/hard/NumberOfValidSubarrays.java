package leetcode.hard;

import java.util.Stack;

public class NumberOfValidSubarrays {
	public int validSubarrays(int[] nums) {

		int result = 0;
		int numsLength = nums.length;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < numsLength; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				int poppedIndex = stack.pop();
				if (i - poppedIndex == 1) {
					continue;
				}
				result += i - poppedIndex - 1;
			}
			stack.push(i);
		}

		int maximumIndex = stack.pop();
		while (!stack.isEmpty()) {
			result += maximumIndex - stack.pop();
		}

		return result + numsLength;

	}
}
