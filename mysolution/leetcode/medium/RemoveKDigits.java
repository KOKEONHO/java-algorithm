package leetcode.medium;

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {

		Stack<Integer> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i=0; i<num.length(); i++) {
			int charNum = Character.getNumericValue(num.charAt(i));
			while (!stack.isEmpty() && stack.peek() > charNum && k > 0) {
				stack.pop();
				k--;
			}
			stack.push(charNum);
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		for (int i=0; i<stack.size(); i++) {
			if (stringBuilder.isEmpty() && stack.get(i) == 0) {
				continue;
			}
			stringBuilder.append(stack.get(i));
		}

		if (stringBuilder.isEmpty()) {
			return "0";
		}
		return stringBuilder.toString();
	}
}
