package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < capital.length; i++) {
            minHeap.add(new int[]{capital[i], profits[i]});
        }

        while (k-- > 0) {

            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.add(minHeap.poll());
            }

            if (!maxHeap.isEmpty()) {
                w += maxHeap.poll()[1];
            }

        }

        return w;

    }

}
