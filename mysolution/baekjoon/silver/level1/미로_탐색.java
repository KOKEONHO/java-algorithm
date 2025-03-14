package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 미로_탐색 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        Deque<int[]> deque = new ArrayDeque<>();

        int[] vertical = new int[] {-1, 0, 1, 0};
        int[] horizontal = new int[] {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            String arrayString = br.readLine();
            for (int j = 0; j < arrayString.length(); j++) {
                matrix[i][j] = Character.getNumericValue(arrayString.charAt(j));
            }
        }

        deque.addLast(new int[] {0, 0});

        while (!deque.isEmpty()) {
            int[] currentNode = deque.pollFirst();
            int currentRow = currentNode[0];
            int currentCol = currentNode[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + vertical[i];
                int nextCol = currentCol + horizontal[i];
                if ((nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M)
                        || matrix[nextRow][nextCol] > 1 || matrix[nextRow][nextCol] == 0) {
                    continue;
                }
                matrix[nextRow][nextCol] = matrix[currentRow][currentCol] + 1;
                deque.addLast(new int[] {nextRow, nextCol});
            }
        }

        System.out.println(matrix[N - 1][M - 1]);

    }
}
