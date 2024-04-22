package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstringsWithNoRepeatedCharacters {
	public int numKLenSubstrNoRepeats(String s, int k) {

		int left = 0;
		int result = 0;
		Set<Character> hashSet = new HashSet<>();

		for (int right = 0; right < s.length(); right++) {
			while (hashSet.contains(s.charAt(right)) || hashSet.size() >= k) {
				hashSet.remove(s.charAt(left));
				left++;
			}

			hashSet.add(s.charAt(right));

			if (hashSet.size() == k) {
				result++;
			}
		}

		return result;

	}
}
