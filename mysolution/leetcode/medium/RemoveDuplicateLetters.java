package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {

		int stringLength = s.length();
		StringBuilder result = new StringBuilder();
		Set<Character> hashSet = new HashSet<>();
		Deque<Character> stack = new ArrayDeque<>();
		Map<Character, Integer> lastOccurence = new HashMap<>();

		for (int i = stringLength - 1; i >= 0; i--) {
			char currentCharacter = s.charAt(i);
			if (!hashSet.contains(currentCharacter)) {
				hashSet.add(currentCharacter);
				lastOccurence.put(currentCharacter, i);
			}
		}

		hashSet.clear();

		for (int i = 0; i < stringLength; i++) {
			char currentCharacter = s.charAt(i);
			while (!stack.isEmpty() && currentCharacter < stack.peek() && !hashSet.contains(currentCharacter)) {
				char topCharacter = stack.peek();
				if (lastOccurence.get(topCharacter) > i) {
					hashSet.remove(stack.pop());
				} else {
					break;
				}
			}
			if (!hashSet.contains(currentCharacter)) {
				stack.push(currentCharacter);
				hashSet.add(currentCharacter);
			}
		}

		while (!stack.isEmpty()) {
			result.append(stack.pollLast());
		}

		return result.toString();

	}
}
