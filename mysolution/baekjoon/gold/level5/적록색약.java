package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {
    static int N;
    static char[][] matrix;
    static boolean[][] visited;
    static int[] vertical = new int[] {-1, 0, 1, 0};
    static int[] horizontal = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrix = new char[N][N];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        int normalCnt = 0;
        int weaknessCnt = 0;

        visited = new boolean[N][N];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    char targetChar = matrix[i][j];
                    dfs(i, j, targetChar);
                    normalCnt++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'G') {
                    matrix[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    char targetChar = matrix[i][j];
                    dfs(i, j, targetChar);
                    weaknessCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + weaknessCnt);

    }

    private static void dfs(int row, int col, char targetChar) {

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + vertical[i];
            int nextCol = col + horizontal[i];
            if ((nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)
                    || visited[nextRow][nextCol] || matrix[nextRow][nextCol] != targetChar) {
                continue;
            }
            dfs(nextRow, nextCol, targetChar);
        }

    }
}
