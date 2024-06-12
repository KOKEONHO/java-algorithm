package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindPlayersWithZeroOrOneLosses {
	public List<List<Integer>> findWinners(int[][] matches) {

		Map<Integer, Integer> scores = new HashMap<>();

		List<Integer> zeroLostPlayers = new ArrayList<>();
		List<Integer> onceLostPlayers = new ArrayList<>();

		for (int[] match : matches) {
			int winner = match[0];
			int loser = match[1];

			if (!scores.containsKey(winner)) {
				scores.put(winner, 0);
			}
			scores.put(loser, scores.getOrDefault(loser, 0) - 1);
		}

		Set<Map.Entry<Integer, Integer>> entrySet = scores.entrySet();
		Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = iterator.next();
			if (entry.getValue() == 0) {
				zeroLostPlayers.add(entry.getKey());
				continue;
			}
			if (entry.getValue() == -1) {
				onceLostPlayers.add(entry.getKey());
			}
		}

		Collections.sort(zeroLostPlayers);
		Collections.sort(onceLostPlayers);

		return Arrays.asList(zeroLostPlayers, onceLostPlayers);

	}
}
