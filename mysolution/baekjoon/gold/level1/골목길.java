package baekjoon.gold.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 골목길 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 노드
        int M = Integer.parseInt(st.nextToken());   // 간선

        int[] dist = new int[N];
        int[] parent = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[0] = 0;    // 시작 노드 initialize

        List<int[]> edges = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;   // 시작 노드
            int v = Integer.parseInt(st.nextToken()) - 1;   // 도착 노드
            int w = Integer.parseInt(st.nextToken());       // 가중치

            edges.add(new int[]{u, v, w});
        }

        for (int i = 0; i < N - 1; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                if (dist[from] != Integer.MIN_VALUE && dist[from] + weight > dist[to]) {
                    dist[to] = dist[from] + weight;
                    parent[to] = from;  // 갱신 시 부모 노드 저장
                }
            }
        }

        List<Integer> updatedNodes = new ArrayList<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            if (dist[from] != Integer.MIN_VALUE && dist[from] + weight > dist[to]) {
                updatedNodes.add(to);
                visited[to] = true;
            }
        }

        Deque<Integer> deque = new ArrayDeque<>(updatedNodes);

        boolean hasOptimalPath = true;

        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();

            if (poll == N - 1) {
                hasOptimalPath = false;
                break;
            }

            for (int[] edge : edges) {
                if (edge[0] == poll) {
                    int next = edge[1];
                    if (!visited[next]) {
                        visited[next] = true;
                        deque.addLast(next);
                    }
                }
            }
        }

        if (!hasOptimalPath || dist[N - 1] == Integer.MIN_VALUE)
            sb.append(-1);
        else {
            Stack<Integer> stack = new Stack<>();
            int node = N - 1;

            while (true) {
                stack.push(node + 1);
                if (node == 0)
                    break;
                node = parent[node];
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
        }

        System.out.println(sb);
    }
}

