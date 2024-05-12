package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {

		int left = 0;
		String temp;
		String result = "";
		int stringLength = s.length();
		Map<Character, Integer> counter = new HashMap<>();

		for (char ch : t.toCharArray()) { // initialize
			counter.put(ch, counter.getOrDefault(ch, 0) + 1);
		}

		for (int right = 0; right < stringLength; right++) {
			char current = s.charAt(right);
			if (counter.containsKey(current)) {
				counter.put(current, counter.get(current) - 1);
				if (counter.get(current) == 0 && counter.values().stream().allMatch(value -> value <= 0)) {
					char front = s.charAt(left);
					while (!counter.containsKey(front) || counter.get(front) < 0) {
						if (counter.containsKey(front)) {
							counter.put(front, counter.get(front) + 1);
						}
						left++;
						front = s.charAt(left);
					}
					temp = s.substring(left, right + 1);
					if (result.isEmpty() || result.length() > temp.length()) {
						result = temp;
					}
					counter.put(front, counter.get(front) + 1);
					left++;
				}
			}
		}

		return result;

	}
}
