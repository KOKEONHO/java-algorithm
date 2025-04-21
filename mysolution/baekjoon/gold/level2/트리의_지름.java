package baekjoon.gold.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리의_지름 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, List<int[]>> map = new HashMap<>();
        Deque<int[]> deque = new ArrayDeque<>();

        int V = Integer.parseInt(br.readLine());

        while (V-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;

            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken()) - 1;

                if (v == -2) {
                    break;
                }

                int w = Integer.parseInt(st.nextToken());

                map.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            }
        }

        int maxWeight = 0;
        int farthestNode = 0;
        deque.addLast(new int[]{0, -1, 0});    // [currentNode, parent, weight]

        /*
            첫 번째 BFS

            weight를 기록하면서 가장 멀리 위치한 노드를 찾아야 함

            maxWeight: 가장 높은 가중치 값
            farthestNode: 가장 높은 가중치의 노드
         */

        while (!deque.isEmpty()) {
            int[] polled = deque.pollFirst();

            int currentNode = polled[0];
            int parent = polled[1];
            int weight = polled[2];

            if (weight > maxWeight) {
                maxWeight = weight;
                farthestNode = currentNode;
            }

            for (int[] neighbor : map.get(currentNode)) {
                if (neighbor[0] != parent) {
                    deque.addLast(new int[]{neighbor[0], currentNode, weight + neighbor[1]});
                }
            }
        }

        /*
            두 번째 BFS

            가장 멀리 위치한 노드에서부터 다시 BFS 실행
         */

        maxWeight = 0;

        deque.addLast(new int[]{farthestNode, -1, 0});

        while (!deque.isEmpty()) {
            int[] polled = deque.pollFirst();

            int currentNode = polled[0];
            int parent = polled[1];
            int weight = polled[2];

            if (weight > maxWeight) {
                maxWeight = weight;
            }

            for (int[] neighbor : map.get(currentNode)) {
                if (neighbor[0] != parent) {
                    deque.addLast(new int[]{neighbor[0], currentNode, weight + neighbor[1]});
                }
            }
        }

        System.out.println(maxWeight);

    }
}
