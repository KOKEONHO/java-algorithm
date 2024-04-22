package leetcode.medium;

public class SubarrayProductLessThanKReference {
	public int numSubarrayProductLessThanK(int[] nums, int k) {

		int left = 0;
		int result = 0;
		int current = 1;

		for (int right = 0; right < nums.length && k > 0; right++) {
			while (current * nums[right] >= k && left < right) {
				current /= nums[left];
				left++;
			}

			current *= nums[right];

			if (current < k) {
				result += right - left + 1;
			}
		}

		return result;
	}
}
