package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderDataInLogFilesReference {

	public String[] reorderLogFiles1(String[] logs) {
		// Comparator 지정

		List<String> letterLogList = new ArrayList<>();
		List<String> digitLogList = new ArrayList<>();

		for (String log : logs) {
			if (Character.isDigit(log.split(" ")[1].charAt(0))) {
				digitLogList.add(log);
				continue;
			}
			letterLogList.add(log);
		}

		letterLogList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				String[] log1 = o1.split(" ", 2);
				String[] log2 = o2.split(" ", 2);

				int compared = log1[1].compareTo(log2[1]);
				if (compared == 0) {
					return log1[0].compareTo(log2[0]);
				}
				return compared;
			}
		});

		letterLogList.addAll(digitLogList);

		return letterLogList.toArray(new String[0]);
	}

	public String[] reorderLogFiles2(String[] logs) {
		// Comparator 지정 - 람다 사용

		List<String> letterLogList = new ArrayList<>();
		List<String> digitLogList = new ArrayList<>();

		for (String log : logs) {
			if (Character.isDigit(log.split(" ")[1].charAt(0))) {
				digitLogList.add(log);
				continue;
			}
			letterLogList.add(log);
		}

		letterLogList.sort((s1, s2) -> {
			String[] log1 = s1.split(" ", 2);
			String[] log2 = s2.split(" ", 2);

			int compared = log1[1].compareTo(log2[1]);

			if (compared == 0) {
				return log1[0].compareTo(log2[0]);
			}
			return compared;
		});

		letterLogList.addAll(digitLogList);

		return letterLogList.toArray(new String[0]);

	}

}
