package baekjoon.silver.level1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 지름길 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 지름길 개수
        int D = Integer.parseInt(st.nextToken());    // 도착 지점

        int[] distance = new int[D + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        Map<Integer, List<int[]>> map = new HashMap<>();    // [도착 노드, 가중치]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));    // [현재 노드, 누적 가중치]

        minHeap.add(new int[]{0, 0});    // 초기화

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (to - from > weight && to <= D) {
                map.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, weight});
            }
        }

        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();

            int currentNode = poll[0];
            int currentDistance = poll[1];

            if (currentNode + 1 <= D && distance[currentNode + 1] > currentDistance + 1) {
                distance[currentNode + 1] = currentDistance + 1;
                minHeap.add(new int[]{currentNode + 1, distance[currentNode + 1]});
            }

            if (!map.containsKey(currentNode)) {
                continue;
            }

            for (int[] neighbor : map.get(currentNode)) {
                int nextNode = neighbor[0];
                int nextDistance = currentDistance + neighbor[1];

                if (distance[nextNode] > nextDistance) {
                    distance[nextNode] = nextDistance;
                    minHeap.add(new int[]{nextNode, nextDistance});
                }
            }
        }

        System.out.println(distance[D]);

    }
}