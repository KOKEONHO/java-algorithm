package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 타임머신 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] dist = new long[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        List<int[]> edges = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new int[]{from, to, weight});
        }

        for (int i = 0; i < N - 1; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                if (dist[from] != Integer.MAX_VALUE && dist[from] + weight < dist[to]) {
                    dist[to] = dist[from] + weight;
                }
            }
        }

        boolean hasNegativeCycle = false;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            if (dist[from] != Integer.MAX_VALUE && dist[from] + weight < dist[to]) {   // 음수 사이클 존재
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle)
            sb.append(-1);
        else {  // 음수 사이클이 존재하지 않을 때
            for (int i = 1; i < N; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append(-1);
                } else {
                    sb.append(dist[i]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}

