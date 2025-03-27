package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    static List<List<Integer>> result;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(0, graph, list);

        return result;

    }


    private void dfs(int node, int[][] graph, List<Integer> list) {

        if (node == graph.length - 1) {
            list.add(node);
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(node);
        int[] connectedNodes = graph[node];

        for (int i = 0; i < connectedNodes.length; i++) {
            dfs(connectedNodes[i], graph, list);
            list.remove(list.size() - 1);
        }

    }
}
