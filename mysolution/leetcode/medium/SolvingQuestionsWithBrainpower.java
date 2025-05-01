package leetcode.medium;

public class SolvingQuestionsWithBrainpower {

    public long mostPoints(int[][] questions) {

        int N = questions.length;

        long[] dp = new long[N];

        dp[N - 1] = questions[N - 1][0];

        for (int i = N - 2; i >= 0; i--) {
            dp[i] = questions[i][0];
            int skip = questions[i][1];

            if (i + skip + 1 < N) {
                dp[i] += dp[i + skip + 1];
            }

            dp[i] = Math.max(dp[i], dp[i + 1]);
        }

        return dp[0];

    }
}
