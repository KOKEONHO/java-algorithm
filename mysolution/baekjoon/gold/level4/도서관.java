package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도서관 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        PriorityQueue<Integer> positiveMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> negativeMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (number < 0) {
                negativeMaxHeap.add(number);
                continue;
            }
            positiveMinHeap.add(number);
        }

        if (negativeMaxHeap.size() > M) {
            if (negativeMaxHeap.size() % M > 0) {
                int remainder = negativeMaxHeap.size() % M;
                for (int i = 0; i < remainder - 1; i++) {
                    negativeMaxHeap.poll();
                }
                result += Math.abs(negativeMaxHeap.poll()) * 2;
            }
        }

        if (positiveMinHeap.size() > M) {
            if (positiveMinHeap.size() % M > 0) {
                int remainder = positiveMinHeap.size() % M;
                for (int i = 0; i < remainder - 1; i++) {
                    positiveMinHeap.poll();
                }
                result += Math.abs(positiveMinHeap.poll()) * 2;
            }
        }

        while (negativeMaxHeap.size() > M) {
            for (int i = 0; i < M - 1; i++) {
                negativeMaxHeap.poll();
            }
            result += Math.abs(negativeMaxHeap.poll()) * 2;
        }

        while (positiveMinHeap.size() > M) {
            for (int i = 0; i < M - 1; i++) {
                positiveMinHeap.poll();
            }
            result += Math.abs(positiveMinHeap.poll()) * 2;
        }

        int lastNegativeAbs = 0;
        while (!negativeMaxHeap.isEmpty()) {
            lastNegativeAbs = Math.abs(negativeMaxHeap.poll());
        }

        int lastPositiveAbs = 0;
        while (!positiveMinHeap.isEmpty()) {
            lastPositiveAbs = Math.abs(positiveMinHeap.poll());
        }

        if (lastNegativeAbs >= lastPositiveAbs) {
            result += (2 * lastPositiveAbs) + lastNegativeAbs;
        } else {
            result += (2 * lastNegativeAbs) + lastPositiveAbs;
        }

        System.out.println(result);

    }
}
