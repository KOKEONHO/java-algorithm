package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static int count;
    static int number;
    static List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {

        count = k;
        number = n;
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        combination(0, 0, list);

        return result;
    }

    private void combination(int depth, int start, List<Integer> list) {

        if (depth == count) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < number; i++) {
            list.add(i + 1);
            combination(depth + 1, i + 1, list);
            list.remove(list.size() - 1);
        }

    }
}
