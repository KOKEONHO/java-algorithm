package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {

		int left = 0;
		int result = 0;
		Map<Character, Integer> hashMap = new HashMap<>();

		for (int right = 0; right < s.length(); right++) {

			char currentChar = s.charAt(right);

			hashMap.put(currentChar, hashMap.getOrDefault(currentChar, 0) + 1);

			if (hashMap.size() > k) {
				result = Math.max(result, right - left);
			}

			while (hashMap.size() > k) {

				char frontChar = s.charAt(left);

				int count = hashMap.get(frontChar);

				if (count > 1) {
					hashMap.put(frontChar, count - 1);
				} else {
					hashMap.remove(frontChar);
				}

				left++;
			}

			if (right == s.length() - 1) {
				return Math.max(result, right - left + 1);
			}

		}

		return result;

	}
}
