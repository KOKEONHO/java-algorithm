package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOfBalloons {
	public int maxNumberOfBalloons(String text) {

		int result = 0;
		boolean flag = true;
		Set<Character> balloonLetters = new HashSet<>(Set.of('b', 'a', 'l', 'o', 'n'));
		Map<Character, Integer> counter = new HashMap<>();

		for (char letter : text.toCharArray()) {
			if (balloonLetters.contains(letter)) {
				counter.put(letter, counter.getOrDefault(letter, 0) + 1);
			}
		}

		if (counter.size() < 5) {
			return 0;
		}

		Set<Map.Entry<Character, Integer>> entrySet = counter.entrySet();

		while (flag) {
			Iterator<Map.Entry<Character, Integer>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Map.Entry<Character, Integer> entry = iterator.next();
				if (entry.getKey() == 'l' || entry.getKey() == 'o') {
					entry.setValue(entry.getValue() - 2);
				} else {
					entry.setValue(entry.getValue() - 1);
				}
				if (entry.getValue() < 0) {
					return result;
				}
			}
			result++;
		}

		return result;
	}
}
