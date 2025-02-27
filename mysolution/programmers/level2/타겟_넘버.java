package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 타겟_넘버 {

    int result = 0;

    public int solution(int[] numbers, int target) {

        dfs(0, numbers, target, 0);

        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0;

        deque.addLast(start);

        for (int number : numbers) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                int value = deque.pollFirst();
                deque.addLast(value + number);
                deque.addLast(value - number);
            }
        }

        while (!deque.isEmpty()) {
            if (target == deque.pollFirst()) {
                result++;
            }
        }

        return result;

    }

    private void dfs(int depth, int[] numbers, int target, int total) {

        if (depth == numbers.length) {
            if (total == target) {
                result++;
            }
            return;
        }

        dfs(depth + 1, numbers, target, total + numbers[depth]);
        dfs(depth + 1, numbers, target, total - numbers[depth]);
    }

}
