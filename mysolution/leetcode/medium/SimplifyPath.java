package leetcode.medium;

import java.util.List;
import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {

		Stack<String> stack = new Stack<>();
		StringBuilder result = new StringBuilder("/");

		for (String pathName : path.split("/")) {
			if (!pathName.isEmpty() && !pathName.equals(".")) {
				if (pathName.equals("..")) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
					continue;
				}
				stack.push(pathName);
			}
		}

		if (stack.isEmpty()) {
			return result.toString();
		}

		List<String> stackList = stack.stream().toList();
		for (int i = 0; i < stackList.size(); i++) {
			result.append(stackList.get(i));
			if (i < stackList.size() - 1) {
				result.append("/");
			}
		}

		return result.toString();

	}
}
