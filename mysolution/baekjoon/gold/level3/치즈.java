package baekjoon.gold.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class 치즈 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Set<Place> outer;
    static List<Place> cheeses;
    static int[] moveRow = new int[]{-1, 0, 1, 0};
    static int[] moveCol = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        cheeses = new ArrayList<>();
        List<Place> remaining = new ArrayList<>();
        Stack<Place> melted = new Stack<>();
        outer = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 1) {
                    cheeses.add(new Place(i, j));
                }
            }
        }

        dfs(0, 0);

        int result = 0;

        while (!cheeses.isEmpty()) {
            for (Place cheese : cheeses) {

                int row = cheese.row;
                int col = cheese.col;

                int outerCnt = 0;

                for (int i = 0; i < 4; i++) {
                    int nextRow = row + moveRow[i];
                    int nextCol = col + moveCol[i];

                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                        continue;
                    }

                    if (map[nextRow][nextCol] == 0 && outer.contains(new Place(nextRow, nextCol))) {
                        outerCnt++;
                    }
                }

                if (outerCnt < 2) {
                    remaining.add(cheese);
                    continue;
                }

                melted.push(cheese);
            }

            cheeses = new ArrayList<>(remaining);
            remaining.clear();

            while (!melted.isEmpty()) {
                Place pop = melted.pop();

                map[pop.row][pop.col] = 0;

                dfs(pop.row, pop.col);
            }

            result++;
        }

        System.out.println(result);

    }

    private static void dfs(
        int row,
        int col
    ) {

        visited[row][col] = true;
        outer.add(new Place(row, col));

        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveRow[i];
            int nextCol = col + moveCol[i];

            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                continue;
            }

            if (map[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                dfs(nextRow, nextCol);
            }
        }

    }

    private static class Place {

        int row;
        int col;

        public Place(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Place)) {
                return false;
            }

            Place other = (Place) obj;
            return row == other.row && col == other.col;

        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
