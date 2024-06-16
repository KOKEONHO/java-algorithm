package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {

		StringBuilder result = new StringBuilder();
		Map<Character, Integer> counter = new HashMap<>();

		for (char letter : s.toCharArray()) {
			counter.put(letter, counter.getOrDefault(letter, 0) + 1);
		}

		List<Character> letters = new ArrayList<>(counter.keySet());
		letters.sort(Comparator.comparingInt((Character letter) -> counter.get(letter)).reversed());

		for (char letter : letters) {
			int letterCount = counter.get(letter);
			while (letterCount > 0) {
				result.append(letter);
				letterCount--;
			}
		}

		return result.toString();

	}
}
