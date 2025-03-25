package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 토마토 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        int M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸 수
        int N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸 수
        int H = Integer.parseInt(st.nextToken()); // 상자의 전체 층 수

        Deque<Tomato> deque = new ArrayDeque<>();

        int totalRow = N * H;

        int[] horizontalRow = new int[] {-1, 0, 1, 0};
        int[] horizontalCol = new int[] {0, 1, 0, -1};
        int[] vertical = new int[] {-N, N};

        int[][] tomatoBox = new int[totalRow][M];

        int totalTomatoCnt = 0;
        int ripeTomatoCnt = 0;

        for (int i = 0; i < totalRow; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoBox[i][j] == -1) {
                    continue;
                }
                totalTomatoCnt++;
                if (tomatoBox[i][j] == 1) {
                    ripeTomatoCnt++;
                    deque.addLast(new Tomato(i, j));
                }
            }
        }

        if (totalTomatoCnt == ripeTomatoCnt) {
            System.out.println(result);
            return;
        }

        while (ripeTomatoCnt < totalTomatoCnt && !deque.isEmpty()) {
            result++;
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                Tomato tomato = deque.pollFirst();

                int currentRow = tomato.row;
                int currentCol = tomato.col;

                for (int j = 0; j < 4; j++) {
                    int nextRow = currentRow + horizontalRow[j];
                    int nextCol = currentCol + horizontalCol[j];

                    if (nextRow < 0 || (currentRow / N != nextRow / N) || nextCol < 0
                            || nextCol >= M) {
                        continue;
                    }

                    if (tomatoBox[nextRow][nextCol] == -1 || tomatoBox[nextRow][nextCol] == 1) {
                        continue;
                    }

                    deque.addLast(new Tomato(nextRow, nextCol));
                    tomatoBox[nextRow][nextCol] = 1;
                    ripeTomatoCnt++;
                }

                for (int j = 0; j < 2; j++) {
                    int nextRow = currentRow + vertical[j];

                    if (nextRow < 0 || nextRow >= totalRow) {
                        continue;
                    }

                    if (tomatoBox[nextRow][currentCol] == -1
                            || tomatoBox[nextRow][currentCol] == 1) {
                        continue;
                    }

                    deque.addLast(new Tomato(nextRow, currentCol));
                    tomatoBox[nextRow][currentCol] = 1;
                    ripeTomatoCnt++;
                }
            }
        }

        if (ripeTomatoCnt != totalTomatoCnt) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);

    }

    private static class Tomato {

        int row;
        int col;

        public Tomato(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }
}
