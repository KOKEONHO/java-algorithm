package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
	public int numSubarraysWithSum(int[] nums, int goal) {

		int result = 0;
		int prefix = 0;
		Map<Integer, Integer> counter = new HashMap<>();

		counter.put(0, 1);

		for (int number : nums) {
			prefix += number;
			if (counter.containsKey(prefix - goal)) {
				result += counter.get(prefix - goal);
			}
			counter.put(prefix, counter.getOrDefault(prefix, 0) + 1);
		}

		return result;

	}
}
