package programmers.level3;

import java.util.ArrayDeque;
import java.util.Deque;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {

        int result = 0;
        int wordsLength = words.length;
        boolean[] visited = new boolean[wordsLength];

        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(begin);

        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                String temp = deque.pollFirst();
                if (temp.equals(target)) {
                    return result;
                }
                for (int j = 0; j < wordsLength; j++) {
                    if (checkConvertable(temp, words[j]) && !visited[j]) {
                        deque.addLast(words[j]);
                        visited[j] = true;
                    }
                }
            }
            result++;
        }

        return 0;

    }

    private boolean checkConvertable(String from, String to) {

        char[] fromArray = from.toCharArray();
        char[] toArray = to.toCharArray();

        int count = 0;

        for (int i = 0; i < fromArray.length; i++) {
            if (fromArray[i] != toArray[i]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        return true;

    }
}
