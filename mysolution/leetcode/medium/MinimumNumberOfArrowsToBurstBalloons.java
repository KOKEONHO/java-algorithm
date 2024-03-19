package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

class MinimumNumberOfArrowsToBurstBalloons {

	public int findMinArrowShots(int[][] points) {

		int[] temp = new int[] {};
		int result = 0;
		Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

		for (int i = 0; i < points.length; i++) {
			if (i == 0) {
				result++;
				temp = new int[] {points[i][0], points[i][1]};
				continue;
			}
			if (temp[0] <= points[i][0] && temp[1] >= points[i][0]) {
				temp = new int[] {Math.max(temp[0], points[i][0]), Math.min(temp[1], points[i][1])};
				continue;
			}
			temp = new int[] {points[i][0], points[i][1]};
			result++;
		}

		return result;
	}
}