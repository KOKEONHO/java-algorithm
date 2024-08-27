package leetcode.medium;

public class NumberOfIslands {

	static int result;
	static int maxRow, maxCol;
	static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;

	public int numIslands(char[][] grid) {

		result = 0;

		maxRow = grid.length;
		maxCol = grid[0].length;
		visited = new boolean[maxRow][maxCol];

		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					dfs(i, j, grid);
					result++;
				}
			}
		}

		return result;
	}

	private static void dfs(int row, int col, char[][] grid) {
		visited[row][col] = true;
		for (int[] direction : directions) {
			int vertical = row + direction[0];
			int horizontal = col + direction[1];
			if (vertical < maxRow && vertical > -1 && horizontal < maxCol && horizontal > -1
				&& !visited[vertical][horizontal] && grid[vertical][horizontal] == '1') {
				dfs(vertical, horizontal, grid);
			}
		}
	}
}
