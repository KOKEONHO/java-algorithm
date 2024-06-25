package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	public String customSortString(String order, String s) {

		StringBuilder result = new StringBuilder();
		Map<Character, Integer> frequencyMap = new HashMap<>();

		for (char alphabet : s.toCharArray()) {
			frequencyMap.put(alphabet, frequencyMap.getOrDefault(alphabet, 0) + 1);
		}

		for (char alphabet : order.toCharArray()) {
			while (frequencyMap.containsKey(alphabet) && frequencyMap.get(alphabet) > 0) {
				result.append(alphabet);
				frequencyMap.put(alphabet, frequencyMap.get(alphabet) - 1);
			}
		}

		for (char alphabet : frequencyMap.keySet()) {
			while (frequencyMap.get(alphabet) > 0) {
				result.append(alphabet);
				frequencyMap.put(alphabet, frequencyMap.get(alphabet) - 1);
			}
		}

		return result.toString();
	}
}
