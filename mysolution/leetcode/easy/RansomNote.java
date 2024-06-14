package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	class Solution {
		public boolean canConstruct(String ransomNote, String magazine) {

			Map<Character, Integer> magazineMap = new HashMap<>();

			for (char letter : magazine.toCharArray()) {
				magazineMap.put(letter, magazineMap.getOrDefault(letter, 0) + 1);
			}

			for (char letter : ransomNote.toCharArray()) {
				if (magazineMap.containsKey(letter)) {
					magazineMap.compute(letter, (key, value) -> {
						if (value - 1 == 0) {
							return null;
						}
						return value - 1;
					});
				} else {
					return false;
				}
			}

			return true;

		}
	}
}
