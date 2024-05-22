package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class BuildingsWithAnOceanView {
	public int[] findBuildings(int[] heights) {

		int length = heights.length;
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < length; i++) {
			int currentHeight = heights[i];
			while (!stack.isEmpty() && heights[stack.peek()] <= currentHeight) {
				stack.pop();
			}
			stack.push(i);
		}

		int stackSize = stack.size();
		int[] result = new int[stackSize];

		for (int i = stackSize - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}

		return result;

	}
}
