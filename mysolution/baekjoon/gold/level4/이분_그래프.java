package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 이분_그래프 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            boolean flag = true;
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            int[] color = new int[V];
            Arrays.fill(color, -1);

            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int i = 0; i < V; i++) {
                if (color[i] == -1) {
                    if (!dfs(i, 0, graph, color)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (!flag) {
                sb.append("NO").append("\n");
                continue;
            }

            sb.append("YES").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean dfs(
        int node,
        int currentColor,
        List<List<Integer>> graph,
        int[] color
    ) {

        color[node] = currentColor;

        List<Integer> neighbors = graph.get(node);

        for (int neighbor : neighbors) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, currentColor ^ 1, graph, color)) {
                    return false;
                }
            }
            if (color[neighbor] == currentColor) {
                return false;
            }
        }

        return true;

    }
}
