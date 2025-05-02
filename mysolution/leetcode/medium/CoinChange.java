package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    private int dp(int[] coins, int remainder) {
        if (remainder == 0)
            return 0;

        if (remainder < 0)
            return -1;

        if (memo.containsKey(remainder))
            return memo.get(remainder);

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = dp(coins, remainder - coin);
            if (result >= 0 && result < min) {
                min = result + 1;
            }
        }

        memo.put(remainder, (min == Integer.MAX_VALUE ? -1 : min));

        return memo.get(remainder);
    }
}
