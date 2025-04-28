package leetcode.medium;

public class HouseRobber {

    public int rob(int[] nums) {

        int N = nums.length;

        if (N == 0)
            return 0;

        int robFar = 0;
        int robNear = nums[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            int robCurrent = Math.max(robNear, robFar + nums[i]);

            robFar = robNear;
            robNear = robCurrent;
        }

        return robNear;

    }
}
