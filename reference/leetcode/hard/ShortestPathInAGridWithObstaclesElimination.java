package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathInAGridWithObstaclesElimination {

  class State {
    int row;
    int col;
    int remain;
    int steps;

    public State(int row, int col, int remain, int steps) {
      this.row = row;
      this.col = col;
      this.remain = remain;
      this.steps = steps;
    }
  }

  public int shortestPath(int[][] grid, int k) {

    int m = grid.length, n = grid[0].length;
    int[] moveRow = new int[]{-1, 0, 1, 0};
    int[] moveCol = new int[]{0, 1, 0, -1};
    Deque<State> deque = new ArrayDeque<>();
    boolean[][][] visited = new boolean[m][n][k + 1];

    deque.addLast(new State(0, 0, k, 0));
    visited[0][0][k] = true;

    while (!deque.isEmpty()) {
      State state = deque.pollFirst();
      if (state.row == m - 1 && state.col == n - 1) {
        return state.steps;
      }
      for (int i = 0; i < 4; i++) {
        int nextRow = state.row + moveRow[i];
        int nextCol = state.col + moveCol[i];
        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
          continue;
        }
        if (grid[nextRow][nextCol] == 1) { // if obstacle
          if (state.remain > 0 && !visited[nextRow][nextCol][state.remain - 1]) {
            deque.addLast(new State(nextRow, nextCol, state.remain - 1, state.steps + 1));
            visited[nextRow][nextCol][state.remain - 1] = true;
          }
        } else { // if not obstacle
          if (!visited[nextRow][nextCol][state.remain]) {
            deque.addLast(new State(nextRow, nextCol, state.remain, state.steps + 1));
            visited[nextRow][nextCol][state.remain] = true;
          }
        }
      }
    }

    return -1;

  }

}
