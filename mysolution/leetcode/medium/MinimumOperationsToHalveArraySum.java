package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {

  public int halveArray(int[] nums) {

    int count = 0;
    double total = 0, half = 0;
    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int num : nums) {
      total += num;
      maxHeap.add((double) num);
    }

    half = total / 2;

    while (total > half) {
      double maxValue = maxHeap.poll();
      double halfMaxValue = maxValue / 2;
      total -= halfMaxValue;
      maxHeap.add(halfMaxValue);
      count++;
    }

    return count;

  }

}
