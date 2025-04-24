package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의_표현 {

    private static int[] parent;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        makeSet(N);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (operation) {
                case 0: // 합집합

                    union(a, b);

                    break;
                case 1:

                    if (find(a) != find(b))
                        sb.append("NO");
                    else
                        sb.append("YES");

                    sb.append("\n");
            }
        }

        System.out.println(sb);

    }

    private static void makeSet(int N) {
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
    }

    private static int find(int number) {
        if (parent[number] != number)
            parent[number] = find(parent[number]);  // 경로 압축

        return parent[number];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB)
            parent[rootB] = rootA;
    }
}

