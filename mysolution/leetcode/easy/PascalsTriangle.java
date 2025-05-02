package leetcode.easy;

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> initialRow = new ArrayList<>(List.of(1));
        result.add(initialRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currRow = new ArrayList<>();

            currRow.add(1);

            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currRow.add(1);
        }

        return result;

    }
}
