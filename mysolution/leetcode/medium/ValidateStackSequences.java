package leetcode.medium;

import java.util.Stack;

public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {

		int index = 0;
		int pushedLength = pushed.length;
		Stack<Integer> stack = new Stack<>();

		for (int number : popped) {
			while (stack.isEmpty() || stack.peek() != number && index < pushedLength) {
				stack.push(pushed[index]);
				index++;
			}
			if (stack.peek() == number) {
				stack.pop();
				continue;
			}
			if (index == pushedLength) {
				return false;
			}
		}

		return true;

	}
}
