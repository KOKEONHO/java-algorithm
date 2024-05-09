package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {

		int left = 0;
		int result = 0;
		int stringLength = s.length();
		Map<Character, Integer> counter = new HashMap<>();

		for (int right = 0; right < stringLength; right++) {
			char current = s.charAt(right);
			counter.put(current, counter.getOrDefault(current, 0) + 1);
			while (counter.size() > 2) {
				char front = s.charAt(left);
				counter.put(front, counter.get(front) - 1);
				if (counter.get(front) == 0) {
					counter.remove(front);
				}
				left++;
			}

			result = Math.max(result, right - left + 1);
		}

		return result;

	}
}
