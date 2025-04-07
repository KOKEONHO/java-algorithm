package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 빙산 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] visited;
    private static int[][] melt;
    private static int[] moveRow = new int[]{-1, 0, 1, 0};
    private static int[] moveCol = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        melt = new int[N][M];
        visited = new int[N][M];
        List<Glacier> glaciers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    glaciers.add(new Glacier(i, j));
                }
            }
        }

        int result = 0;
        int visitNumber = 0;
        boolean flag = true;

        while (flag) {

            // 1. 녹는 양 계산

            for (Glacier glacier : glaciers) {
                int row = glacier.row;
                int col = glacier.col;
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + moveRow[i];
                    int nextCol = col + moveCol[i];

                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                        continue;
                    }

                    if (map[nextRow][nextCol] == 0) {
                        melt[row][col]++;
                    }
                }
            }

            // 2. 빙하 녹이기

            List<Glacier> remainingGlaciers = new ArrayList<>();
            for (Glacier glacier : glaciers) {
                int row = glacier.row;
                int col = glacier.col;
                map[row][col] -= melt[row][col];
                melt[row][col] = 0;
                if (map[row][col] < 0) {
                    map[row][col] = 0;
                    continue;
                }
                if (map[row][col] > 0) {
                    remainingGlaciers.add(glacier);
                }
            }
            glaciers = remainingGlaciers;

            if (remainingGlaciers.isEmpty()) {
                result = 0;
                break;
            }

            // 3. 덩어리 체크
            boolean isFirst = true;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (map[row][col] > 0 && visited[row][col] == visitNumber) {
                        if (isFirst) {
                            dfs(row, col, visitNumber);
                            isFirst = false;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) {
                    break;
                }
            }

            visitNumber++;
            result++;

        }

        System.out.println(result);

    }

    private static void dfs(
        int row,
        int col,
        int visitNumber
    ) {

        visited[row][col]++;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveRow[i];
            int nextCol = col + moveCol[i];

            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                continue;

            }

            if (map[nextRow][nextCol] > 0 && visited[nextRow][nextCol] == visitNumber) {
                dfs(nextRow, nextCol, visitNumber);
            }
        }
    }

    private static class Glacier {

        int row;
        int col;

        public Glacier(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
