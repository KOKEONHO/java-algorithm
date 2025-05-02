package leetcode.easy;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class PascalsTriangle2 {

    Map<Integer, List<Integer>> memo = new HashMap<>();

    public List<Integer> getRow(int rowIndex) {

        memo.put(0, new ArrayList<>(List.of(1)));

        for (int row = 1; row <= rowIndex; row++) {
            List<Integer> prevRow = memo.get(row - 1);
            List<Integer> currRow = new ArrayList<>();

            currRow.add(1);

            for (int i = 1; i < row; i++) {
                currRow.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            currRow.add(1);

            memo.put(row, currRow);
        }

        return memo.get(rowIndex);

    }
}
