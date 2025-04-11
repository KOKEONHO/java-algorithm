package leetcode.medium;

import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();  // [도착 노드, 비용]
        for (int[] flight : flights) {
            int departure = flight[0];
            int arrival = flight[1];
            int price = flight[2];

            graph.putIfAbsent(departure, new ArrayList<>());
            graph.get(departure).add(new int[]{arrival, price});
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }); // [누적 비용, 현재 노드, 경유지 수]

        minHeap.add(new int[]{0, src, 0});

        while (!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();

            int currentPrice = polled[0];
            int currentNode = polled[1];
            int currentSteps = polled[2];

            if (currentSteps > stops[currentNode] || currentSteps > k + 1) {
                continue;
            }

            stops[currentNode] = currentSteps;

            if (currentNode == dst) {
                return currentPrice;
            }

            if (!graph.containsKey(currentNode)) {
                continue;
            }

            for (int[] neighbor : graph.get(currentNode)) {
                int nextPrice = currentPrice + neighbor[1];
                int nextNode = neighbor[0];

                minHeap.add(new int[]{nextPrice, nextNode, currentSteps + 1});
            }
        }

        return -1;

    }
}
