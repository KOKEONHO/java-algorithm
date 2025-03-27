package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int total = 0;
        int start = 0;
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        combination(start, candidates, target, list, total);

        return result;

    }

    private void combination(int start, int[] candidates, int target, List<Integer> list,
            int total) {

        if (total > target) {
            return;
        }

        if (total == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            total += candidates[i];
            list.add(candidates[i]);
            combination(i, candidates, target, list, total);
            total -= candidates[i];
            list.remove(list.size() - 1);
        }

    }
}
