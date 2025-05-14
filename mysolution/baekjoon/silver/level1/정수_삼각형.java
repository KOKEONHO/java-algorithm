package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 삼각형 크기

        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    if (j + k >= n) {
                        continue;
                    }
                    dp[i][j + k] = Math.max(dp[i][j + k], triangle[i][j + k] + dp[i - 1][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int value : dp[n - 1]) {
            max = Math.max(max, value);
        }

        System.out.println(max);

    }
}
