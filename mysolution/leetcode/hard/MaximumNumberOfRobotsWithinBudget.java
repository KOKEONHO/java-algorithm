package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumNumberOfRobotsWithinBudget {
	public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

		Deque<Integer> timeDeque = new ArrayDeque<>();
		Deque<Integer> costDeque = new ArrayDeque<>();

		int result = 0;
		long costSum = 0;
		long totalCost = 0;

		for (int i = 0; i < chargeTimes.length; i++) {
			while (!timeDeque.isEmpty() && chargeTimes[timeDeque.peekLast()] <= chargeTimes[i]) {
				timeDeque.pollLast();
			}
			timeDeque.addLast(i);
			costDeque.addLast(i);
			costSum += runningCosts[i];
			totalCost = chargeTimes[timeDeque.peekFirst()] + costDeque.size() * costSum;
			while (totalCost > budget) {
				int polledIndex = costDeque.pollFirst();
				costSum -= runningCosts[polledIndex];
				if (polledIndex == timeDeque.peekFirst()) {
					timeDeque.pollFirst();
					if (timeDeque.isEmpty()) {
						break;
					}
				}
				totalCost = chargeTimes[timeDeque.peekFirst()] + costDeque.size() * costSum;
			}

			result = Math.max(result, costDeque.size());
		}

		return result;

	}
}
