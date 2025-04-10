package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int K = Integer.parseInt(br.readLine());    // 시작 정점의 번호

        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[K - 1] = 0;

        Map<Integer, List<int[]>> graph = new HashMap<>();  // int[] = [도착 노드, 가중치]

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;   // 시작 노드
            int v = Integer.parseInt(st.nextToken()) - 1;   // 도착 노드
            int w = Integer.parseInt(st.nextToken());       // 가중치

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {    // int[] = [누적 거리, 현재 노드]
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        minHeap.add(new int[]{0, K - 1});   // 시작 누적 거리(0) 및 시작 노드 add

        while (!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();

            int currentDistance = polled[0];
            int currentNode = polled[1];

            if (!graph.containsKey(currentNode)) {
                continue;
            }

            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int nextDistance = currentDistance + neighbor[1];

                if (nextDistance < distances[nextNode]) {
                    distances[nextNode] = nextDistance;
                    minHeap.add(new int[]{nextDistance, nextNode});
                }
            }
        }

        for (int distance : distances) {
            if (distance == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(distance);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
