package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumUnitsOnATruck {
  public int maximumUnits(int[][] boxTypes, int truckSize) {

    int result = 0;

    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[1] - o1[1];
      }
    });

    for (int[] boxType : boxTypes) {
      maxHeap.add(boxType);
    }

    while (truckSize > 0 && !maxHeap.isEmpty()) {
      int[] box = maxHeap.poll();
      if (truckSize >= box[0]) {
        result += box[0] * box[1];
        truckSize -= box[0];
        continue;
      }
      result += truckSize * box[1];
      break;
    }

    return result;

  }
}
