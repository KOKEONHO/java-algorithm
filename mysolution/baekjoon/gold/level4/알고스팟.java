package baekjoon.gold.level4;

import java.util.Arrays;
import java.io.IOException;
import java.util.Comparator;
import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알고스팟 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] moveRow = new int[]{-1, 0, 1, 0};
        int[] moveCol = new int[]{0, 1, 0, -1};

        int result = 0;
        int[][] map = new int[N][M];
        int[][] destroyedWalls = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(destroyedWalls[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        }); // [행, 열, 부순 벽 수]

        minHeap.add(new int[]{0, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();

            int currentRow = polled[0];
            int currentCol = polled[1];
            int currentWalls = polled[2];

            if (currentRow == N - 1 && currentCol == M - 1) {   // [N - 1, M - 1]에 도달했다면
                result = currentWalls;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + moveRow[i];
                int nextCol = currentCol + moveCol[i];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                    continue;
                }

                if (map[nextRow][nextCol] == 1) {   // 벽이라면
                    if (currentWalls + 1 < destroyedWalls[nextRow][nextCol]) {
                        destroyedWalls[nextRow][nextCol] = currentWalls + 1;
                        minHeap.add(new int[]{nextRow, nextCol, currentWalls + 1});
                    }
                } else {
                    if (currentWalls < destroyedWalls[nextRow][nextCol]) {
                        destroyedWalls[nextRow][nextCol] = currentWalls;
                        minHeap.add(new int[]{nextRow, nextCol, currentWalls});
                    }
                }
            }
        }

        System.out.println(result);

    }
}
