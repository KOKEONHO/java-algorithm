package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 게임_맵_최단거리 {

    static Deque<int[]> deque;
    static int[] vertical = new int[] {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] horizontal = new int[] {0, 1, 0, -1}; // 상 우 하 좌

    public int solution(int[][] maps) {

        int directions = 4;
        int rowLength = maps.length;
        int colLength = maps[0].length;

        deque = new ArrayDeque<>();
        deque.addLast(new int[] {0, 0});

        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                int[] currentCell = deque.pollFirst();
                int currentRow = currentCell[0];
                int currentCol = currentCell[1];
                for (int j = 0; j < directions; j++) {
                    int nextRow = currentRow + vertical[j];
                    int nextCol = currentCol + horizontal[j];
                    if ((nextRow < 0 || nextRow >= rowLength || nextCol < 0 || nextCol >= colLength)
                            || maps[nextRow][nextCol] != 1) {
                        continue;
                    }
                    maps[nextRow][nextCol] = maps[currentRow][currentCol] + 1;
                    deque.addLast(new int[] {nextRow, nextCol});
                }
            }
        }

        if (maps[rowLength - 1][colLength - 1] == 1) {
            return -1;
        }
        return maps[rowLength - 1][colLength - 1];
    }
}
