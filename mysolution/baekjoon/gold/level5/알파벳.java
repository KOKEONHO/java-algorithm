package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 알파벳 {

    static int R;
    static int C;
    static char[][] board;
    static boolean[][] visited;
    static int maxMove;
    static int[] vertical = new int[] {-1, 0, 1, 0};
    static int[] horizontal = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 세로 칸 수
        C = Integer.parseInt(st.nextToken()); // 가로 칸 수

        maxMove = 0;
        board = new char[R][C];
        visited = new boolean[R][C];
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, charSet);

        System.out.println(maxMove);

    }

    private static void dfs(int row, int col, Set<Character> charSet) {

        visited[row][col] = true;
        charSet.add(board[row][col]);
        maxMove = Math.max(maxMove, charSet.size());

        for (int i = 0; i < 4; i++) {
            int nextRow = row + vertical[i];
            int nextCol = col + horizontal[i];
            if ((nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C)
                    || visited[nextRow][nextCol] || charSet.contains(board[nextRow][nextCol])) {
                continue;
            }
            dfs(nextRow, nextCol, charSet);
        }

        visited[row][col] = false;
        charSet.remove(board[row][col]);

    }

}
