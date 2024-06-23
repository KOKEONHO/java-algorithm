package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {

		int sLength = s.length();
		Map<Character, Character> sMap = new HashMap<>();
		Set<Character> appearedLetters = new HashSet<>();

		for (int i = 0; i < sLength; i++) {
			char sLetter = s.charAt(i);
			char tLetter = t.charAt(i);
			if (!sMap.containsKey(sLetter)) {
				if (appearedLetters.contains(tLetter)) {
					return false;
				}
				sMap.put(sLetter, tLetter);
				appearedLetters.add(tLetter);
				continue;
			}
			if (sMap.get(sLetter) != tLetter) {
				return false;
			}
		}

		return true;

	}
}
