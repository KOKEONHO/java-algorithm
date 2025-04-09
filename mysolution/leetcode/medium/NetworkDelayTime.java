package leetcode.medium;

import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public int networkDelayTime(
        int[][] times,
        int n,
        int k
    ) {

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;

        Map<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] edge : times) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            int weight = edge[2];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[]{to, weight});
        }

        minHeap.add(new int[]{0, k - 1});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            int currentDistance = current[0];
            int node = current[1];

            if (!graph.containsKey(node)) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];
                int newDistance = currentDistance + weight;

                if (newDistance < distances[next]) {
                    distances[next] = newDistance;
                    minHeap.add(new int[]{newDistance, next});
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int value : distances) {
            if (value == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(value, result);
        }

        return result;

    }
}
