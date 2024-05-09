package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDnaSequences {
	public List<String> findRepeatedDnaSequences(String s) {

		int left = 0;
		int stringLength = s.length();
		Set<String> hashSet = new HashSet<>();
		List<String> result = new ArrayList<>();

		for (int right = 10; right < stringLength + 1; right++) {
			if (right - left > 10) {
				left++;
			}
			String substring = s.substring(left, right);
			if (!hashSet.contains(substring)) {
				hashSet.add(substring);
			} else {
				if (!result.contains(substring)) {
					result.add(substring);
				}
			}
		}

		return result;
	}
}
