package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int prefix = 0;
        int result = 0;

        int[] prefixSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            prefixSum[i] = prefix;
        }

        map.put(0, -1);

        for (int i = 0; i < prefixSum.length; i++) {
            int current = prefixSum[i];
            if (map.containsKey(current - k)) {
                result = Math.max(result, i - map.get(current - k));
            }
            if (!map.containsKey(current)) {
                map.put(current, i);
            }
        }

        return result;

    }
}
