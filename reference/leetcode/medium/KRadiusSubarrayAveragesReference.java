package leetcode.medium;

import java.util.Arrays;

public class KRadiusSubarrayAveragesReference {
	public int[] getAverages(int[] nums, int k) {
		// When a single element is considered then its average will be the number itself only.
		if (k == 0) {
			return nums;
		}

		int windowSize = 2 * k + 1;
		int n = nums.length;
		int[] averages = new int[n];
		Arrays.fill(averages, -1);

		// Any index will not have 'k' elements in its left and right.
		if (windowSize > n) {
			return averages;
		}

		// First get the sum of first window of the 'nums' array.
		long windowSum = 0;
		for (int i = 0; i < windowSize; ++i) {
			windowSum += nums[i];
		}
		averages[k] = (int)(windowSum / windowSize);

		// Iterate on rest indices which have at least 'k' elements
		// on its left and right sides.
		for (int i = windowSize; i < n; ++i) {
			// We remove the discarded element and add the new element to get current window sum.
			// 'i' is the index of new inserted element, and
			// 'i - (window size)' is the index of the last removed element.
			windowSum = windowSum - nums[i - windowSize] + nums[i];
			averages[i - k] = (int)(windowSum / windowSize);
		}

		return averages;
	}
}
