package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주_시식 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 포도주 잔 개수

        int[] cups = new int[n];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            cups[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = cups[0];

        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }

        dp[2] = dp[1] + cups[1];

        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + cups[i - 2] + cups[i - 1], dp[i - 2] + cups[i - 1]));
        }

        System.out.println(dp[n]);

    }
}

