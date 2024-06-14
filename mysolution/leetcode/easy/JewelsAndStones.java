package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
	public int numJewelsInStones(String jewels, String stones) {

		int result = 0;
		Set<Character> jewelsSet = new HashSet<>();

		for (char jewel : jewels.toCharArray()) {
			jewelsSet.add(jewel);
		}

		for (char stone : stones.toCharArray()) {
			if (jewelsSet.contains(stone)) {
				result++;
			}
		}

		return result;

	}
}
