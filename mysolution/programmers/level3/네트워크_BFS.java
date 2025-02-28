package programmers.level3;

import java.util.ArrayDeque;
import java.util.Deque;

public class 네트워크_BFS {

    public int solution(int n, int[][] computers) {

        /*
         * n: 컴퓨터 개수
         * computers: 연결에 대한 정보가 담긴 2차원 배열
         */

        int result = 0;
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                deque.addLast(i);
                visited[i] = true;

                while (!deque.isEmpty()) {
                    int current = deque.pollFirst();
                    for (int j = 0; j < n; j++) {
                        if (computers[current][j] == 1 && !visited[j]) {
                            deque.addLast(j);
                            visited[j] = true;
                        }
                    }
                }
                result++;
            }
        }

        return result;

    }
}
