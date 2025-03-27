package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class N_Queens2 {
    static int total;

    public int totalNQueens(int n) {
        total = 0;
        nQueens(n, 0, new ArrayList<Integer>());
        return total;
    }

    private void nQueens(int n, int row, List<Integer> queenCols) {
        if (row == n) {
            total++;
            return;
        }

        for (int i = 0; i < n; i++) {
            int currentCol = i;
            if (!checkValidity(row, i, queenCols))
                continue;
            queenCols.add(currentCol);
            nQueens(n, row + 1, queenCols);
            queenCols.remove(queenCols.size() - 1);
        }
    }

    private boolean checkValidity(int currentRow, int currentCol, List<Integer> queenCols) {
        for (int i = 0; i < queenCols.size(); i++) {
            int queenRow = i;
            int queenCol = queenCols.get(i);
            if (currentCol == queenCol
                    || Math.abs(currentRow - queenRow) == Math.abs(currentCol - queenCol)) {
                return false;
            }
        }

        return true;
    }
}
