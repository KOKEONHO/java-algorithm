package baekjoon.gold.level2;

import java.io.*;
import java.util.*;

public class 보석_도둑 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        PriorityQueue<Gem> gemWeightMinHeap = new PriorityQueue<>(new Comparator<Gem>() {
            @Override
            public int compare(Gem g1, Gem g2) {
                return g1.weight - g2.weight;
            }
        });

        PriorityQueue<Gem> gemPriceMaxHeap = new PriorityQueue<>(new Comparator<Gem>() {
            @Override
            public int compare(Gem g1, Gem g2) {
                return g2.price - g1.price;
            }
        });

        PriorityQueue<Integer> bagCapacityMinHeap = new PriorityQueue<>();

        while (N-- > 0) {

            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            gemWeightMinHeap.add(new Gem(weight, price));

        }

        while (K-- > 0) {

            bagCapacityMinHeap.add(Integer.parseInt(br.readLine()));

        }

        long result = 0;

        while (!bagCapacityMinHeap.isEmpty()) {

            int bagCapacity = bagCapacityMinHeap.poll();

            while (!gemWeightMinHeap.isEmpty() && bagCapacity >= gemWeightMinHeap.peek().weight) {
                gemPriceMaxHeap.add(gemWeightMinHeap.poll());
            }

            if (!gemPriceMaxHeap.isEmpty()) {
                result += gemPriceMaxHeap.poll().price;
            }

        }

        System.out.println(result);

    }

    private static class Gem {

        int weight;
        int price;

        public Gem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

    }

}

