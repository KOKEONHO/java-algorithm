package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 인구_이동 {

    private static int N, L, R;
    private static int[][] map;
    private static int[][] visited;
    private static List<Nation> nations = new ArrayList<>();
    private static int[] moveRow = new int[]{-1, 0, 1, 0};
    private static int[] moveCol = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 나라 개수
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int visitNumber = 0;

        while (true) {

            boolean crossed = false;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (visited[row][col] == visitNumber) {
                        int totalPopulation = dfs(row, col, visitNumber);
                        if (nations.size() > 1) {
                            crossed = true;
                        }
                        int afterCrossing = totalPopulation / nations.size();
                        for (Nation nation : nations) {
                            map[nation.row][nation.col] = afterCrossing;
                        }
                        nations.clear();
                    }
                }
            }

            if (!crossed) {
                break;
            }

            result++;
            visitNumber++;

        }

        System.out.println(result);

    }

    private static int dfs(
        int row,
        int col,
        int visitNumber
    ) {

        int population = map[row][col];
        int sum = population;
        visited[row][col]++;
        nations.add(new Nation(row, col));

        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveRow[i];
            int nextCol = col + moveCol[i];

            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                continue;
            }

            if (visited[nextRow][nextCol] != visitNumber) {
                continue;
            }

            int neighborPopulation = map[nextRow][nextCol];
            int gap = Math.abs(neighborPopulation - population);

            if (gap < L || gap > R) {
                continue;
            }

            sum += dfs(nextRow, nextCol, visitNumber);
        }

        return sum;

    }

    private static class Nation {

        int row;
        int col;

        public Nation(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
