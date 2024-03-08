package leetcode.easy;

public class ValidPalindromeReference {

	public boolean isPalindromeReference1(String s) {
		// 문자 단위로 추출해서 처리 - while 사용

		int startIndex = 0, endIndex = s.length() - 1;

		while (startIndex < endIndex) {
			while (startIndex < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(startIndex))) {
				startIndex++;
			}

			while (endIndex > 0 && !Character.isLetterOrDigit(s.charAt(endIndex))) {
				endIndex--;
			}

			if (startIndex == s.length() - 1 && endIndex == 0) {
				return true;
			}

			if (Character.toLowerCase(s.charAt(startIndex)) != Character.toLowerCase(s.charAt(endIndex))) {
				return false;
			}

			startIndex++;
			endIndex--;
		}
		return true;
	}

	public boolean isPalindromeReference2(String s) {
		// 문자 단위로 추출해서 처리 - if else 사용

		int startIndex = 0, endIndex = s.length() - 1;

		while (startIndex < endIndex) {
			if (!Character.isLetterOrDigit(s.charAt(startIndex))) {
				startIndex++;
			} else if (!Character.isLetterOrDigit(s.charAt(endIndex))) {
				endIndex--;
			} else if (Character.toLowerCase(s.charAt(startIndex)) != Character.toLowerCase(s.charAt(endIndex))) {
				return false;
			} else {
				startIndex++;
				endIndex--;
			}
		}

		return true;

	}

	public boolean isPalindromeReference3(String s) {
		// 문자열 직접 비교

		String filteredString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		String reversedString = new StringBuilder(filteredString).reverse().toString();
		return filteredString.equals(reversedString);

	}

}
