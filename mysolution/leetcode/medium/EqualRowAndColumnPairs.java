package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EqualRowAndColumnPairs {
	public int equalPairs(int[][] grid) {

		int result = 0;
		int gridLength = grid.length;
		Map<int[], Integer> rowCounter = new HashMap<>();
		Map<int[], Integer> columnCounter = new HashMap<>();

		for (int i = 0; i < gridLength; i++) {
			int[] rowArray = new int[gridLength];
			for (int j = 0; j < gridLength; j++) {
				rowArray[j] = grid[i][j];
			}
			rowCounter.put(rowArray, rowCounter.getOrDefault(rowArray, 0) + 1);

			int[] columnArray = new int[gridLength];
			for (int j = 0; j < gridLength; j++) {
				columnArray[j] = grid[j][i];
			}
			columnCounter.put(columnArray, columnCounter.getOrDefault(columnArray, 0) + 1);
		}

		Set<Map.Entry<int[], Integer>> rowEntrySet = rowCounter.entrySet();
		Set<Map.Entry<int[], Integer>> columnEntrySet = columnCounter.entrySet();

		for (Map.Entry<int[], Integer> rowEntry : rowEntrySet) {
			for (Map.Entry<int[], Integer> columnEntry : columnEntrySet) {
				if (Arrays.equals(rowEntry.getKey(), columnEntry.getKey())) {
					result += rowEntry.getValue() * columnEntry.getValue();
				}
			}
		}

		return result;

	}
}
