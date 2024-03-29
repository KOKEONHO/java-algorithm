package leetcode.easy;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

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

}
