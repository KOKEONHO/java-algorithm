package leetcode.medium;

public class MaxAreaOfIsland {

  boolean[][] visited;
  int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up down left right

  public int maxAreaOfIsland(int[][] grid) {

    int maxArea = 0;
    int row = grid.length, col = grid[0].length;
    visited = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          maxArea = Math.max(maxArea, dfs(grid, i, j));
        }
      }
    }

    return maxArea;

  }

  private int dfs(int[][] grid, int row, int col) {

    int count = 1;
    visited[row][col] = true;

    for (int[] direction : directions) {
      int movedRow = row + direction[0];
      int movedCol = col + direction[1];
      if ((movedRow >= 0 && movedRow < grid.length) && (movedCol >= 0 && movedCol < grid[movedRow].length)) {
        if (grid[movedRow][movedCol] == 1 && !visited[movedRow][movedCol]) {
          count += dfs(grid, movedRow, movedCol);
        }
      }
    }

    return count;

  }

}
