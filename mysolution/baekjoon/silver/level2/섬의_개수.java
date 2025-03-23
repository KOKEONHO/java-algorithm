package baekjoon.silver.level2;

import java.io.*;
import java.util.*;

public class 섬의_개수 {

    static int w, h;
    static int[][] island;
    static int[][] walkDirections =
            new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int islandCnt = 0;
            island = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && island[i][j] == 1) {
                        dfs(i, j);
                        // 해당 칸을 다시 방문할 이유가 없으므로, 백트래킹 X
                        islandCnt++;
                    }
                }
            }

            sb.append(islandCnt).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int row, int col) {

        visited[row][col] = true;

        for (int i = 0; i < walkDirections.length; i++) {
            int[] direction = walkDirections[i];

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= h || newCol < 0 || newCol >= w) {
                continue;
            }

            if (!visited[newRow][newCol] && island[newRow][newCol] == 1) {
                dfs(newRow, newCol);
            }
        }

    }
}
