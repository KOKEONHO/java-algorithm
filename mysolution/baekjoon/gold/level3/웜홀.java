package baekjoon.gold.level3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 웜홀 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());    // 노드(Node) 개수
            int M = Integer.parseInt(st.nextToken());    // 간선(Edge) 개수
            int W = Integer.parseInt(st.nextToken());    // 웜홀 개수

            int[] dist = new int[N];
            List<int[]> edges = new ArrayList<>();

            while (M-- > 0) {    // 도로 입력 - 양방향
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken()) - 1;    // 시작 노드
                int E = Integer.parseInt(st.nextToken()) - 1;    // 도착 노드
                int T = Integer.parseInt(st.nextToken());        // 걸리는 시간

                edges.add(new int[]{S, E, T});
                edges.add(new int[]{E, S, T});
            }

            while (W-- > 0) {    // 웜홀 입력 - 단방향
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken()) - 1;    // 시작 노드
                int E = Integer.parseInt(st.nextToken()) - 1;    // 도착 노드
                int T = -Integer.parseInt(st.nextToken());        // 줄어드는 시간

                edges.add(new int[]{S, E, T});
            }

            for (int i = 0; i < N - 1; i++) {
                for (int[] edge : edges) {
                    int from = edge[0];
                    int to = edge[1];
                    int weight = edge[2];

                    if (dist[from] + weight < dist[to]) {
                        dist[to] = dist[from] + weight;
                    }
                }
            }

            boolean hasNegativeCycle = false;
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                if (dist[from] + weight < dist[to]) {
                    hasNegativeCycle = true;
                    break;
                }
            }

            if (hasNegativeCycle)
                sb.append("YES");
            else
                sb.append("NO");

            sb.append("\n");
        }

        System.out.println(sb);

    }
}
