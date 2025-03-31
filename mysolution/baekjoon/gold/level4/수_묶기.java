package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 수_묶기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        int zeroCnt = 0;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positiveHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negativeHeap = new PriorityQueue<>();

        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (number > 0) {
                positiveHeap.add(number);
                continue;
            }
            if (number < 0) {
                negativeHeap.add(number);
                continue;
            }
            zeroCnt++;
        }

        while (!positiveHeap.isEmpty()) {
            int polled = positiveHeap.poll();
            if (!positiveHeap.isEmpty()) {
                int peeked = positiveHeap.peek();
                int product = polled * peeked;
                if (product > polled) {
                    total += polled * positiveHeap.poll();
                    continue;
                }
            }
            total += polled;
        }

        while (!negativeHeap.isEmpty()) {
            int polled = negativeHeap.poll();
            if (!negativeHeap.isEmpty()) {
                int nextPolled = negativeHeap.poll();
                int product = polled * nextPolled;
                total += product;
                continue;
            }
            if (zeroCnt > 0) {
                zeroCnt--;
                continue;
            }
            total += polled;
        }

        System.out.println(total);

    }
}