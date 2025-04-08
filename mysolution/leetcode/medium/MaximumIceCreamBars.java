package leetcode.medium;

import java.util.PriorityQueue;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {

        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int cost : costs) {
            minHeap.add(cost);
        }

        while (!minHeap.isEmpty() && minHeap.peek() <= coins) {
            coins -= minHeap.poll();
            result++;
        }

        return result;

    }
}
