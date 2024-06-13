package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsToPickUp {
	public int minimumCardPickup(int[] cards) {

		int minimumLength = Integer.MAX_VALUE;
		Map<Integer, Integer> lastOccurence = new HashMap<>();

		for (int i = 0; i < cards.length; i++) {
			if (lastOccurence.containsKey(cards[i])) {
				minimumLength = Math.min(minimumLength, i - lastOccurence.get(cards[i]) + 1);
			}
			lastOccurence.put(cards[i], i);
		}

		if (minimumLength == Integer.MAX_VALUE) {
			return -1;
		}
		return minimumLength;

	}
}
