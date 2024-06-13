package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {

		int prefix = 0;
		int result = 0;
		int numsLength = nums.length;
		Map<Integer, Integer> counter = new HashMap<>();

		counter.put(0, -1);

		for (int i = 0; i < numsLength; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
		}

		for (int i = 0; i < numsLength; i++) {
			prefix += nums[i];
			if (counter.containsKey(prefix)) {
				result = Math.max(result, i - counter.get(prefix));
			} else {
				counter.put(prefix, i);
			}
		}

		return result;

	}
}
