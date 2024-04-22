package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersReference {
	public int lengthOfLongestSubstringWithHashSet(String s) {

		Set<Character> hashSet = new HashSet<>();
		int left = 0, result = 0;

		for (int right = 0; right < s.length(); right++) {
			while (hashSet.contains(s.charAt(right))) {
				hashSet.remove(s.charAt(left));
				left++;
			}

			hashSet.add(s.charAt(right));

			result = Math.max(result, hashSet.size());
		}

		return result;
	}
}
