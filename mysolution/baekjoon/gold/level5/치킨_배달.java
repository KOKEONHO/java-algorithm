package baekjoon.gold.level5;

import java.io.*;
import java.util.*;

public class 치킨_배달 {

    static int N, M;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static List<Node> houseList = new ArrayList<>();
    static List<Node> chickenList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houseList.add(new Node(i, j));
                }
                if (map[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }

        Node[] remainChicken = new Node[M];
        boolean[] visitedChicken = new boolean[chickenList.size()];

        combination(0, 0, remainChicken, visitedChicken);

        System.out.println(result);

    }

    private static void combination(int depth, int start, Node[] remainChicken,
            boolean[] visitedChicken) {

        if (depth == M) {
            int total = 0;
            for (Node house : houseList) {
                int minDistance = Integer.MAX_VALUE;
                for (Node chicken : remainChicken) {
                    minDistance = Math.min(minDistance,
                            Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
                }
                total += minDistance;
            }
            result = Math.min(result, total);
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            if (!visitedChicken[i]) {
                visitedChicken[i] = true;
                remainChicken[depth] = chickenList.get(i);
                combination(depth + 1, i, remainChicken, visitedChicken);
                visitedChicken[i] = false;
            }
        }

    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
