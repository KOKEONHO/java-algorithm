package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    tabulation 풀이
*/

public class 동전_2_Bottom_Up {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 동전 개수
        int k = Integer.parseInt(st.nextToken());   // 목표 합

        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < k + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[k] == k + 1 ? -1 : dp[k]);

    }
}

