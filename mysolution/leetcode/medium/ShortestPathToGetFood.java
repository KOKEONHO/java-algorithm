package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathToGetFood {

  int m, n;
  int[] moveRow = new int[]{-1, 0, 1, 0};
  int[] moveCol = new int[]{0, 1, 0, -1};
  boolean[][] visited;

  public int getFood(char[][] grid) {

    m = grid.length;
    n = grid[0].length;
    visited = new boolean[m][n];

    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == '*') {
          return bfs(row, col, grid);
        }
      }
    }

    return -1;

  }

  private int bfs(int rootRow, int rootCol, char[][] grid) {

    int count = 0;
    Deque<int[]> deque = new ArrayDeque<>();

    deque.addLast(new int[]{rootRow, rootCol});
    visited[rootRow][rootCol] = true;

    while (!deque.isEmpty()) {
      count++;
      int dequeSize = deque.size();
      for (int i = 0; i < dequeSize; i++) {
        int[] currentCell = deque.pollFirst();
        int currentRow = currentCell[0];
        int currentCol = currentCell[1];
        for (int j = 0; j < 4; j++) {
          int nextRow = currentRow + moveRow[j];
          int nextCol = currentCol + moveCol[j];
          if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
            continue;
          }
          if (grid[nextRow][nextCol] == 'O' && !visited[nextRow][nextCol]) {
            deque.addLast(new int[]{nextRow, nextCol});
            visited[nextRow][nextCol] = true;
          } else if (grid[nextRow][nextCol] == '#') {
            return count;
          }
        }
      }
    }

    return -1;

  }

}
