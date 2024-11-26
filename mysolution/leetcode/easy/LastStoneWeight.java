package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

  public int lastStoneWeight(int[] stones) {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int stone : stones) {
      maxHeap.add(stone);
    }

    while (maxHeap.size() > 1) {
      int heavy = maxHeap.poll();
      int light = maxHeap.poll();
      if (heavy == light) {
        continue;
      }
      maxHeap.add(heavy - light);
    }

    if (maxHeap.size() > 0) {
      return maxHeap.poll();
    }
    return 0;

  }

}
