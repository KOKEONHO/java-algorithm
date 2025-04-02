package leetcode.medium;

import java.util.Map;
import java.util.HashMap;

public class MakeSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {

        long totalSum = 0;
        long[] prefixSum = new long[nums.length];
        for (int i = 0; i < prefixSum.length; i++) {
            totalSum += nums[i];
            prefixSum[i] = totalSum;
        }

        long target = totalSum % p;
        if (target == 0) {
            return 0;
        }

        int result = nums.length;
        Map<Long, Integer> modMap = new HashMap<>();
        modMap.put((long) 0, -1);

        for (int i = 0; i < prefixSum.length; i++) {
            long find = (prefixSum[i] - target + p) % p;
            if (modMap.containsKey(find)) {
                int previousIndex = modMap.get(find);
                result = Math.min(result, i - previousIndex);
            }
            modMap.put(prefixSum[i] % p, i);
        }

        return result == nums.length ? -1 : result;

    }
}
