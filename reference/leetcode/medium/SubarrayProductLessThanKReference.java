package leetcode.medium;

public class SubarrayProductLessThanKReference {
	public int numSubarrayProductLessThanK(int[] nums, int k) {

		int left = 0;
		int result = 0;
		int current = 1;

		if (k <= 1) {
			return 0;
		}

		for (int right = 0; right < nums.length; right++) {
			current *= nums[right];

			while (current >= k) {
				current /= nums[left];
				left++;
			}

			result += right - left + 1;
		}

		return result;
	}
}
