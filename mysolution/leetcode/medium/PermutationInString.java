package leetcode.medium;

public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {

		int[] s1Map = new int[26];
		int[] s2Map = new int[26];
		int s1Length = s1.length();
		int s2Length = s2.length();

		if (s1Length > s2Length) {
			return false;
		}

		for (int i = 0; i < s1Length; i++) {
			s1Map[s1.charAt(i) - 'a']++;
			s2Map[s2.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2Length - s1Length; i++) {

			boolean flag = true;
			for (int j = 0; j < 26; j++) {
				if (s1Map[j] != s2Map[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return true;
			}

			s2Map[s2.charAt(s1Length + i) - 'a']++;
			s2Map[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (s1Map[i] != s2Map[i]) {
				return false;
			}
		}
		return true;

	}
}
