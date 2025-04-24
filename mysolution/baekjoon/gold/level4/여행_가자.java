package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행_가자 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        makeSet(N); // initialize

        for (int i = 0; i < N; i++) {
            int a = i + 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int b = Integer.parseInt(st.nextToken());

                if (b == 0)
                    continue;

                union(a, j + 1);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = find(Integer.parseInt(st.nextToken()));

        boolean flag = true;

        while (st.hasMoreTokens()) {
            if (root != find(Integer.parseInt(st.nextToken()))) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");

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
}

