package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {

		int prefix = 0;
		int result = 0;
		Map<Integer, Integer> counter = new HashMap<>();

		counter.put(prefix, 1);

		for (int number : nums) {
			prefix += number;
			if (counter.containsKey(prefix - k)) {
				result += counter.get(prefix - k);
			}
			counter.put(prefix, counter.getOrDefault(prefix, 0) + 1);
		}

		return result;
	}
}
