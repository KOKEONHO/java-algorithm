package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2 {
	public int minMeetingRooms(int[][] intervals) {

		List<Integer> result = new ArrayList<>();

		Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0])
			.thenComparingInt((int[] interval) -> interval[1]));

		for (int[] interval : intervals) {
			boolean flag = true;
			if (!result.isEmpty()) {
				for (int i = result.size() - 1; i >= 0; i--) {
					if (result.get(i) <= interval[0]) {
						result.set(i, interval[1]);
						flag = false;
						break;
					}
				}
				if (flag) {
					result.add(interval[1]);
				}
			} else {
				result.add(interval[1]);
			}
		}

		return result.size();

	}
}
