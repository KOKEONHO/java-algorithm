package programmers.level3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        StringTokenizer st;

        for (String operation : operations) {

            st = new StringTokenizer(operation);
            char command = st.nextToken().charAt(0);
            int value = Integer.parseInt(st.nextToken());

            if (command == 'I') {
                minHeap.add(value);
                maxHeap.add(value);
                continue;
            }

            if (command == 'D') {
                if (value == 1) {
                    minHeap.remove(maxHeap.poll());
                }
                if (value == -1) {
                    maxHeap.remove(minHeap.poll());
                }
            }

        }

        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxHeap.poll(), minHeap.poll()};

    }
}
