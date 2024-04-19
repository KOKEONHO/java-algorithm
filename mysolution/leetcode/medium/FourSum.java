package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int pivot1 = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int pivot2 = nums[j];
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					long sum = (long)pivot1 + pivot2 + nums[left] + nums[right];
					if (sum < target) {
						left++;
						continue;
					}
					if (sum > target) {
						right--;
						continue;
					}
					result.add(Arrays.asList(pivot1, pivot2, nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					left++;
					right--;
				}
			}
		}

		return result;
	}
}
