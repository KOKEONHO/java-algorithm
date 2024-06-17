package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
	public int maximumUniqueSubarray(int[] nums) {

		int sum = 0;
		int left = 0;
		int result = 0;
		Set<Integer> numbers = new HashSet<>();

		for (int right = 0; right < nums.length; right++) {
			int number = nums[right];
			while (numbers.contains(number)) {
				numbers.remove(nums[left]);
				sum -= nums[left++];
			}
			numbers.add(number);
			sum += number;
			result = Math.max(result, sum);
		}

		return result;

	}
}
