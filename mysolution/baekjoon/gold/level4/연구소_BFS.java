package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 연구소_BFS {

    static int N, M;
    static int[][] lab;
    static int[][] copyLab;
    static int result = Integer.MIN_VALUE;
    static Room[] wallInstalledRoomArray;
    static boolean[] visitedEmptyRoomArray;
    static int[] vertical = new int[] {-1, 0, 1, 0};
    static int[] horizontal = new int[] {0, -1, 0, 1};
    static List<Room> virusRoomList = new ArrayList<>();
    static List<Room> emptyRoomList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        wallInstalledRoomArray = new Room[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2)
                    virusRoomList.add(new Room(i, j));
                if (lab[i][j] == 0)
                    emptyRoomList.add(new Room(i, j));
            }
        }

        visitedEmptyRoomArray = new boolean[emptyRoomList.size()];

        combination(0, 0);

        System.out.println(result);

    }

    private static void combination(int depth, int start) {

        Deque<Room> deque = new ArrayDeque<>();

        if (depth == 3) {

            createCopyLab();

            for (Room room : virusRoomList) {

                deque.addLast(room);

                while (!deque.isEmpty()) {

                    Room currentRoom = deque.pollFirst();

                    for (int i = 0; i < 4; i++) {
                        int nextRow = currentRoom.row + vertical[i];
                        int nextCol = currentRoom.col + horizontal[i];

                        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                            continue;
                        }

                        if (copyLab[nextRow][nextCol] != 0) {
                            continue;
                        }

                        copyLab[nextRow][nextCol] = 2;
                        deque.addLast(new Room(nextRow, nextCol));
                    }

                }
            }

            int safeRoomCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyLab[i][j] == 0) {
                        safeRoomCnt++;
                    }
                }
            }

            result = Math.max(result, safeRoomCnt);

            return;
        }

        for (int i = start; i < emptyRoomList.size(); i++) {
            if (!visitedEmptyRoomArray[i]) {
                visitedEmptyRoomArray[i] = true;
                wallInstalledRoomArray[depth] = emptyRoomList.get(i);
                combination(depth + 1, i + 1);
                visitedEmptyRoomArray[i] = false;
            }
        }

    }

    private static void createCopyLab() {

        copyLab = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyLab[i] = lab[i].clone();
        }

        for (Room room : wallInstalledRoomArray) {
            copyLab[room.row][room.col] = 1;
        }

    }

    private static class Room {
        int row;
        int col;

        public Room(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

}

