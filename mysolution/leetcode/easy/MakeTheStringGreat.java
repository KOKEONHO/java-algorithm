package leetcode.easy;

public class MakeTheStringGreat {
	public String makeGood(String s) {

		StringBuilder stack = new StringBuilder();

		for (char letter : s.toCharArray()) {
			if (!stack.isEmpty() && (stack.charAt(stack.length() - 1) - ('a' - 'A') == letter
				|| stack.charAt(stack.length() - 1) + ('a' - 'A') == letter)) {
				stack.deleteCharAt(stack.length() - 1);
				continue;
			}
			stack.append(letter);
		}

		return stack.toString();

	}
}
