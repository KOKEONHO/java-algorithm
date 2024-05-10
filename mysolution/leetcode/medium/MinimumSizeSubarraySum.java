package leetcode.medium;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {

		int sum = 0;
		int left = 0;
		int result = Integer.MAX_VALUE;
		int numsLength = nums.length;

		for (int right = 0; right < numsLength; right++) {
			sum += nums[right];
			while (sum >= target) {
				result = Math.min(result, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}

		if (result == Integer.MAX_VALUE) {
			return 0;
		}
		return result;

	}
}
