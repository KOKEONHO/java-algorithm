package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfVisiblePeopleInAQueue {
	public int[] canSeePersonsCount(int[] heights) {

		int heightsLength = heights.length;
		int[] result = new int[heightsLength];

		Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> temporaryDeque = new ArrayDeque<>();

		for (int i = heightsLength - 1; i >= 0; i--) {
			int height = heights[i];
			while (!deque.isEmpty() && heights[deque.peekFirst()] < height) {
				temporaryDeque.addLast(deque.pollFirst());
			}
			result[i] = temporaryDeque.size();
			if (!deque.isEmpty()) {
				result[i]++;
			}
			deque.addFirst(i);
			while (!temporaryDeque.isEmpty()) {
				if (height < heights[temporaryDeque.peekFirst()]) {
					deque.addLast(temporaryDeque.pollFirst());
				} else {
					temporaryDeque.pollFirst();
				}
			}

		}

		return result;

	}
}
