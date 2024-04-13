package leetcode.medium;

import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {

		Stack<Integer> stack = new Stack<>();
		int[] result = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
				continue;
			}
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int previousIndex = stack.pop();
				result[previousIndex] = i - previousIndex;
			}
			stack.push(i);
		}

		return result;
	}
}
