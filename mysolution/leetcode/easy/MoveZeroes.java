package leetcode.easy;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {

		int left = 0;
		int zeroCount = 0;
		int numsLength = nums.length;

		for (int i = 0; i < numsLength; i++) {
			if (nums[i] == 0) {
				zeroCount++;
			} else {
				nums[left] = nums[i];
				left++;
			}
		}

		for (int i = numsLength - zeroCount; i < numsLength; i++) {
			nums[i] = 0;
		}

	}
}
