package leetcode.medium;

import java.util.Stack;

public class SumOfSubarrayMinimums {
	public int sumSubarrayMins(int[] arr) {

		int mod = 1000000007;

		Stack<Integer> stack = new Stack<>();
		long result = 0;

		int arrLength = arr.length;

		for (int i = 0; i <= arrLength; i++) {
			while (!stack.isEmpty() && (i == arrLength || arr[stack.peek()] >= arr[i])) {
				int mid = stack.pop();
				int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
				int rightBoundary = i;
				long count = (mid - leftBoundary) * (rightBoundary - mid) % mod;
				result += (count * arr[mid]) % mod;
				result %= mod;
			}
			stack.push(i);
		}

		return (int)result;

	}
}
