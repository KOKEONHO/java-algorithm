package leetcode.medium;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
	public int maxVowels(String s, int k) {

		int left = 0;
		int result = 0;
		int vowelCount = 0;
		int length = s.length();

		for (int right = 0; right < length; right++) {
			char currentLetter = s.charAt(right);
			if (right - left < k) {
				if (currentLetter == 'a' || currentLetter == 'e' || currentLetter == 'i' || currentLetter == 'o'
					|| currentLetter == 'u') {
					vowelCount++;
					result = Math.max(result, vowelCount);
				}
			} else {
				if (currentLetter == 'a' || currentLetter == 'e' || currentLetter == 'i' || currentLetter == 'o'
					|| currentLetter == 'u') {
					vowelCount++;
				}
				if (s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i' || s.charAt(left) == 'o'
					|| s.charAt(left) == 'u') {
					vowelCount--;
				}
				result = Math.max(result, vowelCount);
				left++;
			}
		}

		return result;

	}
}
