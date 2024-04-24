package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthTribonacciNumber {
	public int tribonacci(int n) {

		List<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 1));

		int sum = 0;
		int flag = 2;

		for (int right = 0; right < n; right++) {
			sum += nums.get(right);
			if (right >= flag) {
				nums.add(nums.get(right - 2) + nums.get(right - 1) + nums.get(right));
			}
		}

		return nums.get(n);
	}
}
