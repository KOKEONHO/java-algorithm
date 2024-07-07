package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int[] result = new int[nums1.length];
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> nums1Map = new HashMap<>();

		Arrays.fill(result, -1);

		for (int i = 0; i < nums1.length; i++) {
			nums1Map.put(nums1[i], i);
		}

		for (int number : nums2) {
			while (!stack.isEmpty() && stack.peek() < number) {
				int smallNumber = stack.pop();
				if (nums1Map.containsKey(smallNumber)) {
					result[nums1Map.get(smallNumber)] = number;
				}
			}

			stack.push(number);
		}

		return result;

	}
}
