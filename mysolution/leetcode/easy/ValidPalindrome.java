package leetcode.easy;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {

		String string = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		int startIndex = 0, endIndex = string.length() - 1;

		while (startIndex < endIndex) {
			if (string.charAt(startIndex) != string.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}

		return true;

	}

}
