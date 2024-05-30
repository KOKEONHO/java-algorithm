package leetcode.easy;

public class ReversePrefixOfWord {
	public String reversePrefix(String word, char ch) {

		int leftIndex = 0;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ch) {
				char[] charArray = word.toCharArray();
				int rightIndex = i;
				while (leftIndex < rightIndex) {
					char temporary = charArray[leftIndex];
					charArray[leftIndex] = charArray[rightIndex];
					charArray[rightIndex] = temporary;
					leftIndex++;
					rightIndex--;
				}
				return new String(charArray);
			}
		}

		return word;

	}
}
