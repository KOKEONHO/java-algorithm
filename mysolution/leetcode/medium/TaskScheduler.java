package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {

		StringBuilder stringBuilder = new StringBuilder();
		int currentIndex = 1;

		Map<Character, Integer> taskCount = new HashMap<>();
		Map<Character, Integer> taskIndex = new HashMap<>();

		for (char task : tasks) {
			taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
			if (!taskIndex.containsKey(task)) {
				taskIndex.put(task, 0);
			}
		}

		List<Map.Entry<Character, Integer>> taskCountEntryList = new ArrayList<>(taskCount.entrySet());
		taskCountEntryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

		while (!taskCountEntryList.isEmpty()) {
			Iterator<Map.Entry<Character, Integer>> iterator = taskCountEntryList.iterator();
			boolean flag = false;
			while (iterator.hasNext()) {
				Map.Entry<Character, Integer> entry = iterator.next();
				Character targetTask = entry.getKey();
				Integer value = entry.getValue();
				if (taskIndex.get(targetTask) == 0 || currentIndex - taskIndex.get(targetTask) > n) {
					stringBuilder.append(targetTask);
					entry.setValue(value - 1);
					taskIndex.put(targetTask, currentIndex);
					currentIndex++;
					flag = true;
					if (value == 1) {
						iterator.remove();
					}
					taskCountEntryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
					break;
				}
			}
			if (!flag) {
				stringBuilder.append('i');
				currentIndex++;
			}
		}

		return stringBuilder.length();
	}
}
