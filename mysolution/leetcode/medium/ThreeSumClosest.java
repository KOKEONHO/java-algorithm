package leetcode.medium;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {

		int closestValue = Integer.MAX_VALUE;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int pivot = nums[i];
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int total = pivot + nums[left] + nums[right];
				if (total > target) {
					if (Math.abs(target - closestValue) > Math.abs(total - target)) {
						closestValue = total;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					right--;
					continue;
				}
				if (total < target) {
					if (Math.abs(target - closestValue) > Math.abs(target - total)) {
						closestValue = total;
					}
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					left++;
					continue;
				}
				closestValue = total;
				break;
			}
		}

		return closestValue;
	}
}
