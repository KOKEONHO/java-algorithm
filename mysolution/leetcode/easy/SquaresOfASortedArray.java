package leetcode.easy;

public class SquaresOfASortedArray {
	public int[] sortedSquares(int[] nums) {

		int[] result = new int[nums.length];
		int left = 0, right = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			int absBigNumber;
			if (Math.abs(nums[left]) < Math.abs(nums[right])) {
				absBigNumber = nums[right];
				right--;
			} else {
				absBigNumber = nums[left];
				left++;
			}
			result[result.length - (i + 1)] = absBigNumber * absBigNumber;
		}

		return result;
	}
}
