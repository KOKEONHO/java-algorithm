package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPangram {
	public boolean checkIfPangram(String sentence) {

		Set<Character> alphabets = new HashSet<>();

		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
			alphabets.add(alphabet);
		}

		for (int i = 0; i < sentence.length(); i++) {
			alphabets.remove(sentence.charAt(i));
		}

		if (!alphabets.isEmpty()) {
			return false;
		}
		return true;

	}
}
