package leetcode.medium;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {

		int left = 0, right = height.length - 1;
		int storedWater = 0;

		while (left < right) {
			if (height[left] < height[right]) {
				if (storedWater < (height[left] * (right - left))) {
					storedWater = height[left] * (right - left);
				}
				left++;
			} else {
				if (storedWater < (height[right] * (right - left))) {
					storedWater = height[right] * (right - left);
				}
				right--;
			}
		}

		return storedWater;
	}
}
