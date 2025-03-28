package leetcode.medium;

public class WordSearch {
    static int[] moveRow = new int[] {-1, 0, 1, 0};
    static int[] moveCol = new int[] {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTrack(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean backTrack(char[][] board, boolean[][] visited, String word, int depth, int row,
            int col) {

        if (depth == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (board[row][col] != word.charAt(depth)) {
            return false;
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveRow[i];
            int nextCol = col + moveCol[i];
            if (backTrack(board, visited, word, depth + 1, nextRow, nextCol)) {
                return true;
            }
        }

        visited[row][col] = false;
        return false;

    }
}
