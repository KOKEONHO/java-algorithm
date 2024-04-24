package leetcode.medium;

public class MaxConsecutiveOnes {
	public int longestOnes(int[] nums, int k) {

		int left = 0;
		int zeroCount = 0;
		int result = Integer.MIN_VALUE;

		if (nums.length <= k) {
			return nums.length;
		}

		for (int right = 0; right < nums.length; right++) {
			if (zeroCount == k) {
				if (nums[right] == 1) {
					if (right == nums.length - 1) {
						if (result < right - left + 1) {
							return right - left + 1;
						}
						return result;
					}
					continue;
				}
				if (nums[right] == 0) {
					if (right == nums.length - 1) {
						if (result < right - left) {
							return right - left;
						}
						return result;
					}
					if (result < right - left) {
						result = right - left;
					}

					while (nums[left] != 0) {
						left++;
					}
					left++;
					zeroCount--;
				}
			}
			if (nums[right] == 0) {
				zeroCount++;
			}
		}

		if (result == Integer.MIN_VALUE) {
			return nums.length;
		}

		return result;
	}
}
