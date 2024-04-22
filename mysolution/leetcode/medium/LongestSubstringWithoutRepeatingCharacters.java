package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

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
}
