package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemovingStartsFromAString {
	public String removeStars(String s) {

		StringBuilder result = new StringBuilder();
		Deque<Character> deque = new ArrayDeque<>();

		for (char letter : s.toCharArray()) {
			if (letter == '*') {
				if (!deque.isEmpty()) {
					deque.pollLast();
				}
			} else {
				deque.addLast(letter);
			}
		}

		while (!deque.isEmpty()) {
			result.append(deque.pollFirst());
		}

		return result.toString();

	}
}
