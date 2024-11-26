package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {


  private PriorityQueue<Integer> minHeap;
  private PriorityQueue<Integer> maxHeap;

  public FindMedianFromDataStream() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  public void addNum(int num) {
    maxHeap.add(num);
    minHeap.add(maxHeap.poll());
    if (minHeap.size() > maxHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    }
    return (double) (maxHeap.peek() + minHeap.peek()) / 2;
  }

}
