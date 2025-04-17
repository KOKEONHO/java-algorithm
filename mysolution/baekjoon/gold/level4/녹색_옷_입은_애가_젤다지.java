package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색_옷_입은_애가_젤다지 {

    public static void main(String[] args) throws IOException {

        int[] moveRow = new int[]{-1, 0, 1, 0};
        int[] moveCol = new int[]{0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 0;

        while (true) {
            T++;
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            int[][] map = new int[N][N];
            int[][] distances = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(distances[i], Integer.MAX_VALUE);
            }
            distances[0][0] = map[0][0];

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0])); // [누적 거리, 현재 row, 현재 col]

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            minHeap.add(new int[]{map[0][0], 0, 0});

            while (!minHeap.isEmpty()) {
                int[] poll = minHeap.poll();

                int currentDistance = poll[0];
                int currentRow = poll[1];
                int currentCol = poll[2];

                for (int i = 0; i < 4; i++) {
                    int nextRow = currentRow + moveRow[i];
                    int nextCol = currentCol + moveCol[i];

                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                        continue;
                    }

                    int nextDistance = currentDistance + map[nextRow][nextCol];

                    if (nextDistance < distances[nextRow][nextCol]) {
                        distances[nextRow][nextCol] = nextDistance;
                        minHeap.add(new int[]{nextDistance, nextRow, nextCol});
                    }
                }
            }

            sb.append("Problem ").append(T).append(":").append(" ").append(distances[N - 1][N - 1]).append("\n");

        }

        System.out.println(sb);

    }

}

