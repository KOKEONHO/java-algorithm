package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {

		if (intervals.length == 0) {
			return true;
		}

		Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

		int previousEndTime = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (previousEndTime <= intervals[i][0]) {
				previousEndTime = intervals[i][1];
			} else {
				return false;
			}
		}

		return true;

	}
}
