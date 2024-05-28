package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		int arrLength = arr.length;
		List<Integer> result = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>();

		for (int right = 0; right < arrLength; right++) {
			int currentNumber = arr[right];
			if (deque.size() < k) {
				deque.push(currentNumber);
				continue;
			}
			int lastNumber = deque.peekLast();
			if (currentNumber == lastNumber) {
				continue;
			}
			if (Math.abs(currentNumber - x) < Math.abs(lastNumber - x)) {
				deque.removeLast();
				deque.push(currentNumber);
			} else {
				break;
			}
		}

		while (!deque.isEmpty()) {
			result.add(deque.removeLast());
		}

		return result;

	}
}
