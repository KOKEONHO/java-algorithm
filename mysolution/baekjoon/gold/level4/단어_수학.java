package baekjoon.gold.level4;

import java.io.*;
import java.util.*;

public class 단어_수학 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        while (N-- > 0) {
            String input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                char alphabet = input.charAt(i);
                map.put(alphabet,
                        map.getOrDefault(alphabet, 0) + (int) Math.pow(10, input.length() - 1 - i));
            }
        }

        for (int value : map.values()) {
            maxHeap.add(value);
        }

        long total = 0;
        int number = 9;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll() * number--;
        }

        System.out.println(total);

    }
}
