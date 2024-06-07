package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {

		int prefix = 0;
		int maxLength = 0;
		int numsLength = nums.length;
		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < numsLength; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
		}

		hashMap.put(0, -1);
		// key: prefix
		// value: index
		// 0(prefix) -> -1(index)

		for (int i = 0; i < numsLength; i++) {
			prefix += nums[i];
			if (hashMap.containsKey(prefix)) {
				maxLength = Math.max(maxLength, i - hashMap.get(prefix));
			} else {
				hashMap.put(prefix, i);
			}
		}

		return maxLength;

	}
}
