package formula.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnionFind {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());   // 정점 개수
        int E = Integer.parseInt(st.nextToken());   // 간선 개수

        int[] parent = makeSet(V);

        boolean hasCycle = false;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (find(parent, X) == find(parent, Y)) {
                hasCycle = true;
                break;
            }

            union(parent, X, Y);
        }

        if (hasCycle) {
            System.out.println("사이클이 존재합니다!!!");
        } else {
            System.out.println("사이클이 존재하지 않습니다!!!");
        }

    }

    private static int[] makeSet(int V) {
        int[] parent = new int[V + 1];

        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        return parent;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

}
