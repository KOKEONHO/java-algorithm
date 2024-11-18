package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathInBinaryMatrix {

  int[][] grid;
  boolean[][] visited;
  int[] moveRow = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
  int[] moveCol = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

  public int shortestPathBinaryMatrix(int[][] grid) {

    this.grid = grid;
    int n = grid.length;
    visited = new boolean[n][n];

    if (grid[n - 1][n - 1] == 1) {
      return -1;
    }

    bfs(0, 0);

    int result = grid[n - 1][n - 1];
    if (result == 0) {
      return -1;
    }
    return result;

  }

  private void bfs(int rootRow, int rootCol) {

    if (grid[rootRow][rootCol] == 0) {
      grid[rootRow][rootCol] = 1;
      Deque<int[]> deque = new ArrayDeque<>();
      deque.addLast(new int[]{rootRow, rootCol});
      while(!deque.isEmpty()) {
        int[] currentCell = deque.pollFirst();
        int currentRow = currentCell[0], currentCol = currentCell[1];
        visited[currentRow][currentCol] = true;
        for (int i = 0; i < 8; i++) {
          int nextRow = currentRow + moveRow[i];
          int nextCol = currentCol + moveCol[i];
          if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid.length) {
            continue;
          }
          if (grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
            grid[nextRow][nextCol] = grid[currentRow][currentCol] + 1;
            deque.addLast(new int[]{nextRow, nextCol});
          }
        }
      }
    }

  }

}
