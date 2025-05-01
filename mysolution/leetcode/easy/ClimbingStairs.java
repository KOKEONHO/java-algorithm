package leetcode.easy;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] dp = new int[45];

        // initialize
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        if (n < 2) {
            return dp[n];
        }

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1] + dp[n - 2];
    }
}
