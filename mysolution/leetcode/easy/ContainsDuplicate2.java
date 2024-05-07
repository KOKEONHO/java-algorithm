package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		int left = 0;
		boolean result = false;
		Set<Integer> hashSet = new HashSet<>();

		for (int right = 0; right < nums.length; right++) {
			if (hashSet.size() <= k) {
				if (hashSet.contains(nums[right])) {
					result = true;
					break;
				} else {
					hashSet.add(nums[right]);
				}
			} else {
				hashSet.remove(nums[left]);
				left++;
				if (hashSet.contains(nums[right])) {
					result = true;
					break;
				} else {
					hashSet.add(nums[right]);
				}
			}
		}

		return result;

	}
}
