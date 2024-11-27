package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElementsReference {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : arr) {
      if (k > 0) {
        minHeap.add(num);
        k--;
        continue;
      }
      if (Math.abs(minHeap.peek() - x) > Math.abs(num - x)) {
        minHeap.remove();
        minHeap.add(num);
      }
    }

    List<Integer> result = new ArrayList<>();

    while (!minHeap.isEmpty()) {
      result.add(minHeap.poll());
    }

    return result;

  }

}
