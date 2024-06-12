package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumScoreAfterSplittingAString {
	public int maxScore(String s) {

		int result = 0;
		int oneCount = 0;
		int zeroCount = 0;
		int stringLength = s.length();
		Map<Integer, int[]> counter = new HashMap<>();

		for (int i = 0; i < stringLength; i++) {
			if (Character.getNumericValue(s.charAt(i)) == 0) {
				zeroCount++;
			} else {
				oneCount++;
			}
			counter.put(i, new int[] {zeroCount, oneCount});
		}

		for (int i = 0; i < stringLength - 1; i++) {
			result = Math.max(result, counter.get(i)[0] + (counter.get(stringLength - 1)[1] - counter.get(i)[1]));
		}

		return result;
	}
}
