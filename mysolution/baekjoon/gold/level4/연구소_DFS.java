package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연구소_DFS {

    static int N, M;
    static int[][] lab;
    static int[][] copyLab;
    static int result = Integer.MIN_VALUE;
    static List<Room> emptyRoomList = new ArrayList<>();
    static List<Room> virusRoomList = new ArrayList<>();
    static boolean[] visitedEmptyRoomArray;
    static Room[] selectedEmptyRoomArray = new Room[3];
    static int[] vertical = new int[] {-1, 0, 1, 0};
    static int[] horizontal = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virusRoomList.add(new Room(i, j));
                }
                if (lab[i][j] == 0) {
                    emptyRoomList.add(new Room(i, j));
                }
            }
        }

        visitedEmptyRoomArray = new boolean[emptyRoomList.size()];

        combination(0, 0);

        System.out.println(result);
    }

    private static void combination(int depth, int start) {

        if (depth == 3) {
            deepCopyLab();
            for (Room virus : virusRoomList) {
                dfs(virus.x, virus.y);
            }

            int safetyCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyLab[i][j] == 0) {
                        safetyCnt++;
                    }
                }
            }

            result = Math.max(result, safetyCnt);

            return;
        }

        for (int i = start; i < emptyRoomList.size(); i++) {
            if (!visitedEmptyRoomArray[i]) {
                visitedEmptyRoomArray[i] = true;
                selectedEmptyRoomArray[depth] = emptyRoomList.get(i);
                combination(depth + 1, i + 1);
                visitedEmptyRoomArray[i] = false;
            }
        }

    }

    private static void dfs(int row, int col) {

        for (int i = 0; i < 4; i++) {
            int newRow = row + vertical[i];
            int newCol = col + horizontal[i];

            if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) {
                continue;
            }

            if (copyLab[newRow][newCol] != 0) {
                continue;
            }

            copyLab[newRow][newCol] = 2;
            dfs(newRow, newCol);

        }

    }

    private static void deepCopyLab() {

        copyLab = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyLab[i] = lab[i].clone();
        }

        // 선택된 비어있는 방 3개에 벽 설치
        for (Room emptyRoom : selectedEmptyRoomArray) {
            copyLab[emptyRoom.x][emptyRoom.y] = 1;
        }

    }

    private static class Room {

        int x;
        int y;

        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
