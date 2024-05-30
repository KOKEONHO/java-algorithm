package leetcode.medium;

public class GetEqualSubstringsWithinBudget {
	public int equalSubstring(String s, String t, int maxCost) {

		int sum = 0;
		int left = 0;
		int result = 0;
		int length = s.length();

		for (int right = 0; right < length; right++) {
			sum += Math.abs(s.charAt(right) - t.charAt(right));
			if (sum <= maxCost) {
				result = Math.max(result, right - left + 1);
			}
			while (sum > maxCost) {
				sum -= Math.abs(s.charAt(left) - t.charAt(left));
				left++;
			}
		}

		return result;

	}
}
