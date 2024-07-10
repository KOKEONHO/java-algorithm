package leetcode.medium;

import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {

		boolean loopStop;
		Stack<Integer> stack = new Stack<>();

		for (int asteroid : asteroids) {
			loopStop = false;
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroid);
					continue;
				}
				int collisionResult = stack.peek() + asteroid;
				if (collisionResult > 0) {
					continue;
				} else if (collisionResult == 0) {
					stack.pop();
					continue;
				}
				while (collisionResult < 0) {
					stack.pop();
					if (stack.isEmpty()) {
						break;
					}
					if (stack.peek() < 0) {
						loopStop = true;
						break;
					}
					collisionResult = stack.peek() + asteroid;
				}
				if (stack.isEmpty()) {
					stack.push(asteroid);
					continue;
				} else {
					if (loopStop) {
						stack.push(asteroid);
						continue;
					}
					if (collisionResult > 0) {
						continue;
					} else if (collisionResult == 0) {
						stack.pop();
					}
				}

			}
		}

		int[] result = new int[stack.size()];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}

		return result;

	}
}
