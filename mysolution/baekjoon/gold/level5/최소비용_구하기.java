package baekjoon.gold.level5;

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

public class 최소비용_구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }); // [누적 가중치, 현재 노드]

        StringTokenizer st;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;   // 시작 노드
            int v = Integer.parseInt(st.nextToken()) - 1;   // 도착 노드
            int w = Integer.parseInt(st.nextToken());   // 가중치

            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(new int[]{v, w});    // [도착 노드, 가중치]
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken()) - 1;   // 시작 노드
        int arrive = Integer.parseInt(st.nextToken()) - 1;  // 도착 노드

        int result = 0;
        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        minHeap.add(new int[]{0, start});

        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();

            int currentDistance = poll[0];
            int currentNode = poll[1];

            if (currentNode == arrive) {
                result = currentDistance;
                break;
            }

            if (!map.containsKey(currentNode)) {
                continue;
            }

            for (int[] neighbor : map.get(currentNode)) {
                int nextNode = neighbor[0];
                int nextDistance = currentDistance + neighbor[1];

                if (nextDistance < distances[nextNode]) {
                    distances[nextNode] = nextDistance;
                    minHeap.add(new int[]{nextDistance, nextNode});
                }
            }
        }

        System.out.println(result);

    }
}

