package leetcode.medium;

public class NumberOfIslands {

	int row = 0;
	int col = 0;
	boolean[][] visited;
	int[][] directionArray = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up down left right

	public int numIslands(char[][] grid) {

		int islandCount = 0;
		row = grid.length;
		col = grid[0].length;
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					dfs(grid, i, j);
					islandCount++;
				}
			}
		}

		return islandCount;

	}

	private void dfs(char[][] grid, int i, int j) {

		visited[i][j] = true;
		for (int[] direction : directionArray) {
			if ((i + direction[0] < row && i + direction[0] >= 0) && (j + direction[1] < col && j + direction[1] >= 0)) {
				if (grid[i + direction[0]][j + direction[1]] == '1' && !visited[i + direction[0]][j + direction[1]]) {
					dfs(grid, i + direction[0], j + direction[1]);
				}
			}
		}

	}

}
