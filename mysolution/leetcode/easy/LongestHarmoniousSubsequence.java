package leetcode.easy;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {

		Arrays.sort(nums);

		int left = 0;
		int result = 0;

		for (int right = 1; right < nums.length; right++) {
			while (nums[right] - nums[left] > 1 && left < right) {
				left++;
			}

			if (nums[right] - nums[left] == 1) {
				result = Math.max(result, right - left + 1);
			}

		}

		return result;
	}
}
