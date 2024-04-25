package leetcode.medium;

public class NumberOfWaysToSplitArray {
	public int waysToSplitArray(int[] nums) {

		int result = 0;

		long[] prefix = new long[nums.length];
		prefix[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			prefix[i] = prefix[i - 1] + nums[i];
		}

		for (int i = 0; i < prefix.length - 1; i++) {
			if (prefix[i] >= prefix[prefix.length - 1] - prefix[i]) {
				result++;
			}
		}

		return result;
	}
}
