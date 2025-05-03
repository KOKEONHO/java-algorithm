package baekjoon.gold.level4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_1_Bottom_Up {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());    // 동전 종류 수
        int k = Integer.parseInt(st.nextToken());    // 목표 합

        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int coin : coins) {
            for (int i = 0; i < k + 1; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        System.out.println(dp[k]);

    }
}