package leetcode.easy;

import java.util.HashMap;

public class TwoSum {

	public int[] twoSumByBruteForce(int[] nums, int target) {

		int num1, num2;
		for (int i = 0; i < nums.length; i++) {
			num1 = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				num2 = nums[j];
				if ((num1 + num2) == target) {
					return new int[] {i, j};
				}
			}
		}
		return null;

	}

	public static int[] twoSumByHashMap(int[] nums, int target) {

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int num1 = 0, num2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				return new int[] {i, hashMap.get(target - nums[i])};
			}
			hashMap.put(nums[i], i);
		}

		return null;
	}

}