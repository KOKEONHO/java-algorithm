package baekjoon.gold.level3;

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

public class 파티 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 마을 숫자 == 학생 숫자
        int M = Integer.parseInt(st.nextToken());   // 단방향 도로 개수
        int X = Integer.parseInt(st.nextToken()) - 1;   // 모이기로 한 마을 번호

        int[] firstDistances = new int[N];
        int[] secondDistances = new int[N];
        Arrays.fill(firstDistances, Integer.MAX_VALUE);
        Arrays.fill(secondDistances, Integer.MAX_VALUE);

        firstDistances[X] = 0;
        secondDistances[X] = 0;

        Map<Integer, List<int[]>> graph = new HashMap<>();  // [도착 노드, 가중치]

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[]{to, weight});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }); // [누적 거리, 현재 노드]

        for (int i = 0; i < N; i++) {
            if (i == X) {
                continue;
            }

            int[] distances = new int[N];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[i] = 0;

            minHeap.add(new int[]{0, i});
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

            firstDistances[i] = distances[X];
        }

        minHeap.add(new int[]{0, X});

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

                if (nextDistance < secondDistances[nextNode]) {
                    secondDistances[nextNode] = nextDistance;
                    minHeap.add(new int[]{nextDistance, nextNode});
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, firstDistances[i] + secondDistances[i]);
        }

        System.out.println(result);

    }
}
