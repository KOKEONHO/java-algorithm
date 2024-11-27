package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

  public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int num : nums) {
      maxHeap.add(num);
    }

    while (k - 1 > 0) {
      maxHeap.remove();
      k--;
    }

    return maxHeap.poll();

  }

}
