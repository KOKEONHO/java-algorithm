package baekjoon.gold.level3;

import java.io.*;
import java.util.*;

public class 벽_부수고_이동하기 {

    static int[] moveRow = new int[]{-1, 0, 1, 0};
    static int[] moveCol = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        Deque<Node> deque = new ArrayDeque<>();

        deque.addLast(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!deque.isEmpty()) {
            Node current = deque.pollFirst();

            if (current.row == N - 1 && current.col == M - 1) {
                System.out.println(current.distance);
                return;
            }

            int currentDistance = current.distance;
            boolean currentWallBroken = current.wallBroken;

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + moveRow[i];
                int nextCol = current.col + moveCol[i];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                    continue;
                }

                /*
                    벽이 존재하지 않고, 방문하지 않았다면 deque에 추가
                    다만, current의 wallBroken이 true인지 false인지에 따라 분기 처리 필요
                */

                if (map[nextRow][nextCol] == 0 && !visited[nextRow][nextCol][currentWallBroken ? 1
                    : 0]) {
                    deque.addLast(
                        new Node(nextRow, nextCol, currentDistance + 1, currentWallBroken));
                    visited[nextRow][nextCol][currentWallBroken ? 1 : 0] = true;
                    continue;
                }

                /*
                    벽이 존재한다면, 벽을 부수고 방문 처리
                    다만, 벽을 부수지 않았어야 함
                */

                if (map[nextRow][nextCol] == 1 && !currentWallBroken
                    && !visited[nextRow][nextCol][1]) {
                    deque.addLast(new Node(nextRow, nextCol, currentDistance + 1, true));
                    visited[nextRow][nextCol][1] = true;
                }

            }

        }

        System.out.println(-1);

    }

    private static class Node {

        int row;
        int col;
        int distance;
        boolean wallBroken;

        public Node(int row, int col, int distance, boolean wallBroken) {
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.wallBroken = wallBroken;
        }

    }
}