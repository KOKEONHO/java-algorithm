package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

  public int minStoneSum(int[] piles, int k) {

    int total = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int pile : piles) {
      maxHeap.add(pile);
    }

    for (int i = 0; i < k; i++) {
      int maxPile = maxHeap.poll();
      maxHeap.add((int) Math.ceil((double) maxPile / 2));
    }

    while (!maxHeap.isEmpty()) {
      total += maxHeap.poll();
    }

    return total;

  }

}
