package baekjoon.gold.level4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 플로이드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, List<int[]>> map = new HashMap<>();    // int[] : [도착 도시, 비용(가중치)]
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;   // 시작 도시
            int b = Integer.parseInt(st.nextToken()) - 1;   // 도착 도시
            int c = Integer.parseInt(st.nextToken());   // 비용(가중치)

            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(new int[]{b, c});    // [도착 도시, 비용(가중치)]
        }

        PriorityQueue<int[]> distanceMinHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0])); // [누적 비용(가중치), 현재 도시]

        for (int i = 0; i < N; i++) {
            int[] distances = new int[N];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[i] = 0;

            distanceMinHeap.add(new int[]{0, i});

            while (!distanceMinHeap.isEmpty()) {
                int[] poll = distanceMinHeap.poll();

                int currentDistance = poll[0];
                int currentCity = poll[1];

                if (!map.containsKey(currentCity)) {
                    continue;
                }

                for (int[] city : map.get(currentCity)) {
                    int nextDistance = currentDistance + city[1];
                    int nextCity = city[0];

                    if (nextDistance < distances[nextCity]) {
                        distances[nextCity] = nextDistance;
                        distanceMinHeap.add(new int[]{nextDistance, nextCity});
                    }
                }

            }

            for (int distance : distances) {
                if (distance == Integer.MAX_VALUE) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(distance).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}

