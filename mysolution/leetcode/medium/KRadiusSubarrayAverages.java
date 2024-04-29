package leetcode.medium;

public class KRadiusSubarrayAverages {
	public int[] getAverages(int[] nums, int k) {

		long sum = 0;
		int divider = (2 * k) + 1;
		int[] average = new int[nums.length];

		for (int i = 0; i < divider && i < nums.length; i++) {
			sum += nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			if (i < k || i >= nums.length - k) {
				average[i] = -1;
			} else if (i == k) {
				average[i] = (int)(sum / divider);
			} else {
				sum += nums[i + k];
				sum -= nums[i - k - 1];
				average[i] = (int)(sum / divider);
			}
		}

		return average;
	}
}
