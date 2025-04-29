package baekjoon.gold.level4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소_스패닝_트리 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());   // 정점 개수
        int E = Integer.parseInt(st.nextToken());   // 간선 개수

        int[] parent = makeSet(V);
        PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            edges.add(new int[]{A, B, C});
        }

        int result = 0;

        while (!edges.isEmpty()) {
            int[] poll = edges.poll();

            int from = poll[0];
            int to = poll[1];
            int weight = poll[2];

            if (find(parent, from) == find(parent, to))
                continue;

            union(parent, from, to);
            result += weight;
        }

        System.out.println(result);

    }

    private static int[] makeSet(int V) {
        int[] parent = new int[V + 1];

        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        return parent;
    }

    private static int find(int[] parent, int node) {
        if (parent[node] != node)
            parent[node] = find(parent, parent[node]);

        return parent[node];
    }

    private static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB)
            parent[rootB] = rootA;
    }

}
