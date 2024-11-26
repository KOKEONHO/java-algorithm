package leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> counts = new HashMap<>();

    for (int num : nums) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(counts::get));

    for (int num : counts.keySet()) {
      heap.add(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    int[] result = new int[k];
    for (int i = 0; i < result.length; i++) {
      result[i] = heap.poll();
    }

    return result;

  }

}
