package leetcode.easy;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

  PriorityQueue<Integer> minHeap;
  int k;

  public KthLargestElementInAStream(int k, int[] nums) {
    minHeap = new PriorityQueue<>();
    this.k = k;

    for (int num : nums) {
      add(num);
    }
  }

  public int add(int val) {

    if (minHeap.size() < k || minHeap.peek() < val) {
      minHeap.add(val);
      if (minHeap.size() > k) {
        minHeap.remove();
      }
    }

    return minHeap.peek();

  }

}
