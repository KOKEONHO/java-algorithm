package leetcode.hard;

import java.util.Stack;

public class TrappingRainWater {
	public int trap(int[] height) {

		Stack<Integer> stack = new Stack<>();
		int maximumIndex = 0, result = 0;

		for (int i = 0; i < height.length; i++) {
			if (height[i] > height[maximumIndex]) {
				maximumIndex = i;
			}
		}

		int wall = 0;
		for (int i = 0; i <= maximumIndex; i++) {
			if (height[i] > 0 && wall <= height[i]) {
				while (!stack.isEmpty()) {
					result += wall - stack.pop();
				}
				wall = height[i];
				continue;
			}
			if (wall > 0) {
				stack.push(height[i]);
			}
		}

		wall = 0;
		for (int i = height.length - 1; i >= maximumIndex; i--) {
			if (height[i] > 0 && wall <= height[i]) {
				while (!stack.isEmpty()) {
					result += wall - stack.pop();
				}
				wall = height[i];
				continue;
			}
			if (wall > 0) {
				stack.push(height[i]);
			}
		}

		return result;
	}
}
