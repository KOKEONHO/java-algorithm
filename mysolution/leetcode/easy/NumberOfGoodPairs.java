package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfGoodPairs {
	public int numIdenticalPairs(int[] nums) {

		int result = 0;
		Map<Integer, List<Integer>> indicies = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (indicies.containsKey(nums[i])) {
				indicies.get(nums[i]).add(i);
				continue;
			}
			indicies.put(nums[i], new ArrayList<>());
			indicies.get(nums[i]).add(i);
		}

		for (List<Integer> list : indicies.values()) {
			if (list.size() > 1) {
				int size = list.size() - 1;
				while (size > 0) {
					result += size;
					size--;
				}
			}
		}

		return result;

	}
}
