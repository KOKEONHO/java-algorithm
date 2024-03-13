package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWordReference {

	public String mostCommonWord1(String paragraph, String[] banned) {
		// 금지어 목록이 String 배열이므로 → 비교 메서드를 제공하는 Set으로 변경

		Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> wordCount = new HashMap<>();

		String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

		for (String word : words) {
			if (!bannedSet.contains(word)) {
				wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
			}
		}

		return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();

	}

	public String mostCommonWord2(String paragraph, String[] banned) {

		Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> wordCount = new HashMap<>();

		Arrays.stream(paragraph.replaceAll("\\W+", " ").toLowerCase().split(" "))
			.filter(word -> !bannedSet.contains(word))
			.forEach(word -> wordCount.put(word, wordCount.getOrDefault(word, 0) + 1));

		return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();

	}

}
