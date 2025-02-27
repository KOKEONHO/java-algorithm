package leetcode.medium;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

  public int partitionArray(int[] nums, int k) {

    Arrays.sort(nums); // 1. sort

    int result = 1;
    int minVal = nums[0];

    for (int num : nums) {
      if (num - minVal > k) {
        result++;
        minVal = num;
      }
    }

    return result;

  }

}
