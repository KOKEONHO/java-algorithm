package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    static List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();

        nQueens(n, 0, new ArrayList<String>(), new ArrayList<Integer>());

        return result;

    }

    private void nQueens(int n, int row, List<String> list, List<Integer> queenCols) {

        if (row == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!checkValidity(row, i, queenCols)) {
                continue;
            }
            queenCols.add(i);
            list.add(createString(n, i));
            nQueens(n, row + 1, list, queenCols);
            queenCols.remove(queenCols.size() - 1);
            list.remove(list.size() - 1);
        }

    }

    private String createString(int n, int col) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i == col) {
                sb.append("Q");
                continue;
            }
            sb.append(".");
        }

        return sb.toString();

    }

    private boolean checkValidity(int currentRow, int currentCol, List<Integer> queenCols) {

        for (int i = 0; i < queenCols.size(); i++) {

            int queenRow = i;
            int queenCol = queenCols.get(i);

            if (currentCol == queenCol
                    || Math.abs(queenRow - currentRow) == Math.abs(queenCol - currentCol)) {
                return false;
            }

        }

        return true;

    }
}
