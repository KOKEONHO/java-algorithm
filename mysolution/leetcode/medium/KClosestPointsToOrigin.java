package leetcode.medium;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


  public int[][] kClosest(int[][] points, int k) {

    PriorityQueue<Point> minHeap = new PriorityQueue<>((p1, p2) -> {
      int p1Distance = (int) (Math.pow(p1.x, 2) + Math.pow(p1.y, 2));
      int p2Distance = (int) (Math.pow(p2.x, 2) + Math.pow(p2.y, 2));

      // 만약 `p1Distance`가 더 크다면 양수가 반환 -> 우선순위가 b가 더 높아야 함
      // 만약 `p2Distance`가 더 크다면 음수가 반환 -> 우선순위가 a가 더 높아야 함

      return p1Distance - p2Distance;
    });

    for (int[] point : points) {
      minHeap.add(new Point(point[0], point[1]));
    }

    int[][] result = new int[k][2];

    for (int i = 0; i < k; i++) {
      Point point = minHeap.poll();
      result[i][0] = point.x;
      result[i][1] = point.y;
    }

    return result;

  }

}
