package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static int[] numbers;
    static List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {

        numbers = nums;
        result = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            int start = 0;
            int depth = 0;
            List<Integer> list = new ArrayList<>();
            combination(depth, start, i, list);
        }

        return result;

    }

    private void combination(int depth, int start, int n, List<Integer> list) {

        if (depth == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            list.add(numbers[i]);
            combination(depth + 1, i + 1, n, list);
            list.remove(list.size() - 1);
        }

    }
}
