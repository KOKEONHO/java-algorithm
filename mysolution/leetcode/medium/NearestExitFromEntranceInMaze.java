package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class NearestExitFromEntranceInMaze {

  public int nearestExit(char[][] maze, int[] entrance) {

    int[] moveRow = new int[]{-1, 0, 1, 0};
    int[] moveCol = new int[]{0, 1, 0, -1};

    int m = maze.length, n = maze[0].length;

    boolean[][] visited = new boolean[m][n];

    Deque<int[]> deque = new ArrayDeque<>();

    int step = 0;
    deque.addLast(entrance);
    visited[entrance[0]][entrance[1]] = true;

    while (!deque.isEmpty()) {
      int dequeSize = deque.size();
      for (int i = 0; i < dequeSize; i++) {
        int[] currentCell = deque.pollFirst();
        for (int j = 0; j < 4; j++) {
          int nextRow = currentCell[0] + moveRow[j];
          int nextCol = currentCell[1] + moveCol[j];
          if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) { // exit
            if (currentCell[0] == entrance[0] && currentCell[1] == entrance[1]) {
              continue;
            }
            return step;
          }
          if (maze[nextRow][nextCol] == '.' && !visited[nextRow][nextCol]) {
            deque.addLast(new int[]{nextRow, nextCol});
            visited[nextRow][nextCol] = true;
          }
        }
      }
      step++;
    }

    return -1;

  }

}
