package leetcode.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfTheLongestValidSubstringReference {
	public int longestValidSubstring(String word, List<String> forbidden) {

		int result = 0;
		int wordLength = word.length();
		Set<String> forbiddenSet = new HashSet<>(forbidden);

		int right = wordLength - 1;
		for (int left = wordLength - 1; left >= 0; left--) {
			for (int end = left; end < Math.min(left + 10, right + 1); end++) {
				if (forbiddenSet.contains(word.substring(left, end + 1))) {
					right = end - 1;
					break;
				}
			}
			result = Math.max(result, right - left + 1);
		}

		return result;
	}
}
