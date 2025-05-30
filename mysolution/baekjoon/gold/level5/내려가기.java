package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내려가기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    maxDp[i][j] = map[i][j];
                    minDp[i][j] = map[i][j];
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]) + map[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]) + map[i][j];
                    continue;
                }
                if (j == 2) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j - 1], maxDp[i - 1][j]) + map[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j - 1], minDp[i - 1][j]) + map[i][j];
                    continue;
                }
                maxDp[i][j] = Math.max(maxDp[i - 1][j], Math.max(maxDp[i - 1][j - 1], maxDp[i - 1][j + 1])) + map[i][j];
                minDp[i][j] = Math.min(minDp[i - 1][j], Math.min(minDp[i - 1][j - 1], minDp[i - 1][j + 1])) + map[i][j];
            }
        }

        Arrays.sort(maxDp[N - 1]);
        Arrays.sort(minDp[N - 1]);

        sb.append(maxDp[N - 1][2]).append(" ").append(minDp[N - 1][0]);

        System.out.println(sb);

    }

}

