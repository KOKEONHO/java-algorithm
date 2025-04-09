package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리 {

    private static int N;
    private static int deleteNode;
    private static Map<Integer, List<Integer>> childrenMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int rootNode = 0;
        childrenMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int node = 0; node < N; node++) {
            int head = Integer.parseInt(st.nextToken());
            if (head == -1) {
                rootNode = node;
                continue;
            }
            if (childrenMap.containsKey(head)) {
                childrenMap.get(head).add(node);
                continue;
            }
            childrenMap.put(head, new ArrayList<>());
            childrenMap.get(head).add(node);
        }

        deleteNode = Integer.parseInt(br.readLine());

        int result = dfs(rootNode);

        System.out.println(result);
    }

    private static int dfs(
        int node
    ) {

        int leafCnt = 0;

        if (node == deleteNode) {
            return 0;
        }

        if (!childrenMap.containsKey(node)) {
            return 1;
        }

        List<Integer> leaves = childrenMap.get(node);
        if (leaves.isEmpty()) {
            return 1;
        }

        for (int leaf : leaves) {
            leafCnt += dfs(leaf);
        }

        if (leafCnt == 0) {
            return 1;
        }

        return leafCnt;

    }

}
