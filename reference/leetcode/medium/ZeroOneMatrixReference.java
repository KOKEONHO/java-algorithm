package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class ZeroOneMatrixReference {

  int m, n;
  int[] moveRow = new int[]{-1, 0, 1, 0};
  int[] moveCol = new int[]{0, 1, 0, -1};

  public int[][] updateMatrix(int[][] mat) {

    m = mat.length;
    n = mat[0].length;

    Deque<int[]> deque = new ArrayDeque<>();
    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          deque.addLast(new int[]{i, j});
          visited[i][j] = true;
        }
      }
    }

    bfs(deque, mat, visited);

    return mat;

  }

  private void bfs(Deque<int[]> deque, int[][] mat, boolean[][] visited) {

    while (!deque.isEmpty()) {
      int[] currentCell = deque.pollFirst();
      int currentRow = currentCell[0], currentCol = currentCell[1];
      for (int i = 0; i < 4; i++) {
        int nextRow = currentRow + moveRow[i], nextCol = currentCol + moveCol[i];
        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
          continue;
        }
        if (mat[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          deque.addLast(new int[]{nextRow, nextCol});
          mat[nextRow][nextCol] = mat[currentRow][currentCol] + 1;
        }
      }
    }

  }
}
