package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 타겟_넘버_BFS {

    public int solution(int[] numbers, int target) {

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;
        int result = 0;

        deque.add(0);

        while (index < numbers.length) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                int current = deque.pollFirst();
                if (index == numbers.length - 1) {
                    if (current + numbers[index] == target) {
                        result++;
                    }
                    if (current - numbers[index] == target) {
                        result++;
                    }
                }
                deque.addLast(current + numbers[index]);
                deque.addLast(current - numbers[index]);
            }
            index++;
        }

        return result;

    }
}