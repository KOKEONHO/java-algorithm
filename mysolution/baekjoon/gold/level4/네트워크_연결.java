package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크_연결 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 컴퓨터 개수
        int M = Integer.parseInt(br.readLine());    // 간선 개수

        makeSet(N);

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;   // 출발 컴퓨터
            int b = Integer.parseInt(st.nextToken()) - 1;   // 도착 컴퓨터
            int c = Integer.parseInt(st.nextToken());       // 간선 설치 비용

            edges.add(new Edge(a, b, c));
        }

        int result = 0;

        while (!edges.isEmpty()) {
            Edge poll = edges.poll();

            int from = poll.from;
            int to = poll.to;
            int cost = poll.cost;

            if (find(from) == find(to)) {   // 이미 같은 그룹이라면
                continue;
            }

            union(from, to);
            result += cost;
        }

        System.out.println(result);

    }

    private static void makeSet(int N) {
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
    }

    private static int find(int a) {
        if (parent[a] != a)
            parent[a] = find(parent[a]);

        return parent[a];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    private static class Edge {

        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.from, this.to, this.cost);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (!(obj instanceof Edge))
                return false;

            Edge other = (Edge) obj;
            return this.from == other.from && this.to == other.to && this.cost == other.cost;
        }
    }

}
