package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 영역_구하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> areaList = new ArrayList<>();

        int M = Integer.parseInt(st.nextToken()); // 행
        int N = Integer.parseInt(st.nextToken()); // 열
        int K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        int[][] matrix = new int[M][N];
        Deque<Node> deque = new ArrayDeque<>();

        int[] vertical = new int[] {-1, 0, 1, 0};
        int[] horizontal = new int[] {0, 1, 0, -1};

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());

            int leftDownX = Integer.parseInt(st.nextToken());
            int leftDownY = Integer.parseInt(st.nextToken());

            int rightUpX = Integer.parseInt(st.nextToken());
            int rightUpY = Integer.parseInt(st.nextToken());

            int leftDownRow = (M - 1) - leftDownY;
            int leftDownCol = leftDownX;

            int rightUpRow = M - rightUpY;
            int rightUpCol = rightUpX - 1;

            for (int i = rightUpRow; i < leftDownRow + 1; i++) {
                for (int j = leftDownCol; j < rightUpCol + 1; j++) {
                    matrix[i][j] = 1;
                }
            }

        }

        int areaCnt = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {

                    areaCnt++;
                    int area = 0;

                    deque.addLast(new Node(i, j));
                    matrix[i][j] = 1;

                    while (!deque.isEmpty()) {
                        Node currentNode = deque.pollFirst();
                        area++;

                        int currentRow = currentNode.row;
                        int currentCol = currentNode.col;

                        for (int k = 0; k < 4; k++) {

                            int nextRow = currentRow + vertical[k];
                            int nextCol = currentCol + horizontal[k];

                            if (nextRow < 0 || nextRow >= M || nextCol < 0 || nextCol >= N) {
                                continue;
                            }

                            if (matrix[nextRow][nextCol] == 0) {
                                deque.addLast(new Node(nextRow, nextCol));
                                matrix[nextRow][nextCol] = 1;
                            }
                        }
                    }

                    areaList.add(area);
                }
            }
        }

        areaList.sort(Comparator.naturalOrder());

        sb.append(areaCnt).append("\n");

        for (int area : areaList) {
            sb.append(area).append(" ");
        }

        System.out.println(sb);

    }

    private static class Node {

        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }
}
