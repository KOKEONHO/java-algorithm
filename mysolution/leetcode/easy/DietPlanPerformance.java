package leetcode.easy;

public class DietPlanPerformance {
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

		int left = 0;
		int temp = 0;
		int result = 0;

		for (int right = 0; right < calories.length; right++) {

			temp += calories[right];
			k--;

			if (k == 0) {
				if (temp > upper) {
					result++;
				} else if (temp < lower) {
					result--;
				}
				temp -= calories[left];
				left++;
				k++;
			}
		}

		return result;

	}
}
