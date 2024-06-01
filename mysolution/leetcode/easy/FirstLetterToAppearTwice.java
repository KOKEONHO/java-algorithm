package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterToAppearTwice {
	public char repeatedCharacter(String s) {

		Set<Character> hashSet = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			if (hashSet.contains(s.charAt(i))) {
				return s.charAt(i);
			}
			hashSet.add(s.charAt(i));
		}

		return ' ';

	}
}
