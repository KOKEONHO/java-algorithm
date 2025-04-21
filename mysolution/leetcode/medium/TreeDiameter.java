package leetcode.medium;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class TreeDiameter {

    public int treeDiameter(int[][] edges) {

        if (edges.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<int[]> deque = new ArrayDeque<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int farthestNode = 0;
        deque.addLast(new int[]{0, -1});    // [node, parent]

        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            int node = poll[0];
            int parent = poll[1];
            farthestNode = node;

            for (int neighbor : map.get(node)) {
                if (neighbor != parent) {
                    deque.addLast(new int[]{neighbor, node});
                }
            }
        }

        int depth = -1;
        deque.addLast(new int[]{farthestNode, -1});

        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int[] poll = deque.pollFirst();
                int node = poll[0];
                int parent = poll[1];

                for (int neighbor : map.get(node)) {
                    if (neighbor != parent) {
                        deque.addLast(new int[]{neighbor, node});
                    }
                }

            }
        }

        return depth;

    }
}