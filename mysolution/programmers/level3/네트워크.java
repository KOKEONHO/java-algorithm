package programmers.level3;

public class 네트워크 {

    public static void main(String[] args) {

        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

    }

    public static int solution(int n, int[][] computers) {

        int result = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visited[i]) {
                    visited[j] = true;
                    dfs(j, visited, computers);
                    result++;
                }
            }
        }

        return result;

    }

    private static void dfs(int node, boolean[] visited, int[][] computers) {

        for (int i = 0; i < computers[node].length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, visited, computers);
            }
        }

    }

}
