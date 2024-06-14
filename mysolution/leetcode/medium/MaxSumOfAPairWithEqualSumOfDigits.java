package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfAPairWithEqualSumOfDigits {
	public int maximumSum(int[] nums) {

		int result = -1;
		int maximum = 0;
		Map<Integer, Integer> lastMaxNumber = new HashMap<>();

		for (int number : nums) {
			int digitSum = getDigitSum(number);
			if (lastMaxNumber.containsKey(digitSum)) {
				result = Math.max(result, number + lastMaxNumber.get(digitSum));
			}
			lastMaxNumber.put(digitSum, Math.max(lastMaxNumber.getOrDefault(digitSum, 0), number));
		}

		return result;

	}

	public int getDigitSum(int number) {
		int digitSum = 0;
		while (number > 0) {
			digitSum += number % 10;
			number /= 10;
		}

		return digitSum;
	}
}
