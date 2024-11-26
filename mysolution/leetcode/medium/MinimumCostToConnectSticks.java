package leetcode.medium;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

  public int connectSticks(int[] sticks) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int stick : sticks) {
      minHeap.add(stick);
    }

    int total = 0;

    while (minHeap.size() > 1) {
      int first = minHeap.poll();
      int second = minHeap.poll();
      int sum = first + second;
      total += sum;
      minHeap.add(sum);
    }

    return total;

  }

}
