package leetcode.medium;

import java.util.Arrays;

public class HouseRobberReference {

  private int[] memo;

  public int rob(int[] nums) {

    this.memo = new int[nums.length];
    Arrays.fill(this.memo, -1);

    return robFrom(0, nums);

  }

  private int robFrom(int i, int[] nums) {

    // base case
    if (i >= nums.length) {
      return 0;
    }

    // return cached value
    if (this.memo[i] > -1) {
      return this.memo[i];
    }

    // recursion
    int answer = Math.max(
        this.robFrom(i + 1, nums),
        this.robFrom(i + 2, nums) + nums[i]
    );

    this.memo[i] = answer;

    return answer;

  }

}
