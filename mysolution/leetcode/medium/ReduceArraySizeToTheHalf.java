package leetcode.medium;

import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {
  public int minSetSize(int[] arr) {

    int arrLength = arr.length;
    int half = arrLength / 2;
    int result = 0;

    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[1] - o1[1];
      }
    });

    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (Integer key : map.keySet()) {
      maxHeap.add(new int[] {key, map.get(key)});
    }

    while (!maxHeap.isEmpty() && arrLength > half) {
      result++;
      arrLength -= maxHeap.poll()[1];
    }

    return result;

  }
}
