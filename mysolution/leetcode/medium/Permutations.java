package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        int depth = 0;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();

        permutation(depth, nums, visited, list, result);

        return result;
    }

    private void permutation(int depth, int[] nums, boolean[] visited, List<Integer> list,
            List<List<Integer>> result) {

        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                permutation(depth + 1, nums, visited, list, result);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }
}
