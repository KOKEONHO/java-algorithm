package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {

		int result = 0;
		List<Character> list = new ArrayList<>();

		for (int right = 0; right < s.length(); right++) {
			if (!list.contains(s.charAt(right))) {
				list.add(s.charAt(right));
				result = Math.max(result, list.size());
				continue;
			}

			while (list.contains(s.charAt(right))) {
				list.remove(0);
			}
			list.add(s.charAt(right));
		}

		return result;
	}

	public int lengthOfLongestSubstringWithHashMap(String s) {

		int left = 0, result = 0;
		Map<Character, Integer> hashMap = new HashMap<>();

		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);
			hashMap.put(currentChar, hashMap.getOrDefault(currentChar, 0) + 1);

			while (hashMap.get(currentChar) > 1) {
				hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
				if (hashMap.get(s.charAt(left)) == 0) {
					hashMap.remove(s.charAt(left));
				}
				left++;
			}

			result = Math.max(result, hashMap.size());
		}

		return result;
	}
}
