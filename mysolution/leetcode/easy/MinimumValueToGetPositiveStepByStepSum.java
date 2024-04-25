package leetcode.easy;

import java.util.Arrays;

public class MinimumValueToGetPositiveStepByStepSum {
	public int minStartValue(int[] nums) {

		int[] prefix = new int[nums.length];

		prefix[0] = nums[0];

		for (int i = 1; i < prefix.length; i++) {
			prefix[i] = prefix[i - 1] + nums[i];
		}

		Arrays.sort(prefix);

		if (prefix[0] < 0) {
			return -prefix[0] + 1;
		}
		return 1;

	}
}
