package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int result = 0;
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int card = Integer.parseInt(br.readLine());
            minHeap.add(card);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int total = first + second;
            result += total;
            minHeap.add(total);
        }

        System.out.println(result);

    }
}
