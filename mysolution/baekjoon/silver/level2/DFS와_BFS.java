package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class DFS와_BFS {
    static int n, m, v;
    static int[][] matrix;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        visited = new boolean[n];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken()) - 1;
            int num2 = Integer.parseInt(st.nextToken()) - 1;
            matrix[num1][num2] = 1;
            matrix[num2][num1] = 1;
        }

        dfs(v - 1);

        sb.append("\n");
        visited = new boolean[n];

        bfs(v - 1);

        System.out.println(sb);
    }

    private static void dfs(int node) {

        visited[node] = true;
        sb.append(node + 1).append(" ");
        for (int i = 0; i < matrix[node].length; i++) {
            if (matrix[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {

        Deque<Integer> deque = new ArrayDeque<>();
        visited[node] = true;
        deque.addLast(node);

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();
            sb.append(current + 1).append(" ");
            for (int j = 0; j < matrix[current].length; j++) {
                if (matrix[current][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    deque.addLast(j);
                }
            }
        }

    }
}
