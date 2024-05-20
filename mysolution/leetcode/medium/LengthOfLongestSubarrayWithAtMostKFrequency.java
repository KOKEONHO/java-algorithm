package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
	public int maxSubarrayLength(int[] nums, int k) {

		int left = 0, right = 0;
		int result = 0;
		Map<Integer, Integer> counter = new HashMap<>();

		for (right = 0; right < nums.length; right++) {
			int number = nums[right];
			counter.put(number, counter.getOrDefault(number, 0) + 1);
			while (counter.get(number) > k) {
				result = Math.max(result, right - left);
				int front = nums[left];
				counter.put(front, counter.get(front) - 1);
				left++;
			}
		}

		return Math.max(result, right - left);

	}
}
