package leetcode.easy;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LargestUniqueNumber {
	public int largestUniqueNumber(int[] nums) {

		Map<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

		for (int number : nums) {
			treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
		}

		Set<Map.Entry<Integer, Integer>> entrySet = treeMap.entrySet();
		Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = iterator.next();
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return -1;

	}
}
