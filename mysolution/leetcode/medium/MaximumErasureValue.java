package leetcode.medium;

public class MaximumErasureValue {

	public int maximumUniqueSubarray(int[] nums) {

		int sum = 0;
		int left = 0;
		int result = 0;
		int[] numbers = new int[10001];

		for (int right = 0; right < nums.length; right++) {
			int rightNumber = nums[right];
			if (numbers[rightNumber] < 1) {
				numbers[rightNumber]++;
				sum += rightNumber;
				continue;
			}
			result = Math.max(result, sum);
			while (numbers[nums[right]] > 0) {
				int leftNumber = nums[left];
				numbers[leftNumber]--;
				sum -= leftNumber;
				left++;
			}
			numbers[rightNumber]++;
			sum += rightNumber;
		}

		return Math.max(result, sum);

	}

}
