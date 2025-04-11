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

public class 특정한_최단_경로 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점 개수
        int E = Integer.parseInt(st.nextToken());   // 간선 개수

        Map<Integer, List<int[]>> graph = new HashMap<>();

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(new int[]{b, c});  // [도착 노드, 거리]

            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(new int[]{a, c});  // [도착 노드, 거리]
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken()) - 1;   // 무조건 지나야하는 정점1
        int v2 = Integer.parseInt(st.nextToken()) - 1;   // 무조건 지나야하는 정점2

        int route1 = 0; // v1을 먼저 지나는 최단 거리
        int route2 = 0; // v2를 먼저 지나는 최단 거리

        int[] zeroDistances = new int[N];
        int[] v1Distances = new int[N];
        int[] v2Distances = new int[N];

        Arrays.fill(zeroDistances, Integer.MAX_VALUE);
        Arrays.fill(v1Distances, Integer.MAX_VALUE);
        Arrays.fill(v2Distances, Integer.MAX_VALUE);

        zeroDistances[0] = 0;
        v1Distances[v1] = 0;
        v2Distances[v2] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }); // [누적 거리, 현재 노드]

        minHeap.add(new int[]{0, 0});

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

                if (nextDistance < zeroDistances[nextNode]) {
                    zeroDistances[nextNode] = nextDistance;
                    minHeap.add(new int[]{nextDistance, nextNode});
                }
            }
        }

        boolean route1Exist = true;
        boolean route2Exist = true;

        route1 += zeroDistances[v1];
        if (zeroDistances[v1] == Integer.MAX_VALUE) {
            route1Exist = false;
        }
        route2 += zeroDistances[v2];
        if (zeroDistances[v2] == Integer.MAX_VALUE) {
            route2Exist = false;
        }

        minHeap.add(new int[]{0, v1});

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

                if (nextDistance < v1Distances[nextNode]) {
                    v1Distances[nextNode] = nextDistance;
                    minHeap.add(new int[]{nextDistance, nextNode});
                }
            }
        }

        route1 += v1Distances[v2];
        if (v1Distances[v2] == Integer.MAX_VALUE) {
            route1Exist = false;
        }
        route2 += v1Distances[N - 1];
        if (v1Distances[N - 1] == Integer.MAX_VALUE) {
            route2Exist = false;
        }

        minHeap.add(new int[]{0, v2});

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

                if (nextDistance < v2Distances[nextNode]) {
                    v2Distances[nextNode] = nextDistance;
                    minHeap.add(new int[]{nextDistance, nextNode});
                }
            }
        }

        route1 += v2Distances[N - 1];
        if (v2Distances[N - 1] == Integer.MAX_VALUE) {
            route1Exist = false;
        }
        route2 += v2Distances[v1];
        if (v2Distances[v1] == Integer.MAX_VALUE) {
            route2Exist = false;
        }

        int result = Math.min(route1, route2);
        if (!route1Exist && !route2Exist) {
            result = -1;
        }

        System.out.println(result);

    }
}
