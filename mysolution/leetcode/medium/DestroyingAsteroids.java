package leetcode.medium;

import java.util.PriorityQueue;

public class DestroyingAsteroids {

  public boolean asteroidsDestroyed(int mass, int[] asteroids) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    long total = mass;

    for (int asteroid : asteroids) {
      minHeap.add(asteroid);
    }

    while (!minHeap.isEmpty()) {
      if (total < minHeap.peek()) {
        return false;
      }
      total += minHeap.poll();
    }

    return true;

  }

}
