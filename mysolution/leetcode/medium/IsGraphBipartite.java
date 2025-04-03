package leetcode.medium;

import java.util.Arrays;

class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color)) {
                    return false;
                }
            }
        }

        return true;

    }

    private boolean dfs(
        int node,
        int currentColor,
        int[][] graph,
        int[] color
    ) {

        color[node] = currentColor;

        for (int neighbor : graph[node]) {
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