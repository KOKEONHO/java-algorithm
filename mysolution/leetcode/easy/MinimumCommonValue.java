package leetcode.easy;

public class MinimumCommonValue {
	public int getCommon(int[] nums1, int[] nums2) {

		boolean flag = false;
		int nums1Index = 0, nums2Index = 0;

		while (nums1Index < nums1.length && nums2Index < nums2.length) {
			if (nums1[nums1Index] > nums2[nums2Index]) {
				nums2Index++;
			} else if (nums1[nums1Index] < nums2[nums2Index]) {
				nums1Index++;
			} else {
				flag = true;
				break;
			}
		}

		if (flag) {
			return nums1[nums1Index];
		}
		return -1;

	}
}
