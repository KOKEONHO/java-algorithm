package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> anagrams = new HashMap<>();

		for (String word : strs) {
			char[] wordArray = word.toCharArray();
			Arrays.sort(wordArray);
			String sortedWord = String.valueOf(wordArray);
			if (anagrams.containsKey(sortedWord)) {
				anagrams.get(sortedWord).add(word);
				continue;
			}
			anagrams.put(sortedWord, new ArrayList<>());
			anagrams.get(sortedWord).add(word);
		}

		return new ArrayList<>(anagrams.values());

	}
}
