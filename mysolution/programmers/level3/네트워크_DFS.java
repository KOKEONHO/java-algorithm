package programmers.level3;

public class 네트워크_DFS {

    public int solution(int n, int[][] computers) {

        int result = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                result++;
            }
        }

        return result;

    }

    private void dfs(int node, boolean[] visited, int[][] computers) {

        visited[node] = true;

        for (int i = 0; i < computers[node].length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, visited, computers);
            }
        }

    }

}
